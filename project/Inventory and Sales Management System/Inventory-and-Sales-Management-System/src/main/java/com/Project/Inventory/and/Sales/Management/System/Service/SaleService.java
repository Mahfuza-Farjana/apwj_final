package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.DTO.SaleRequestDTO;
import com.Project.Inventory.and.Sales.Management.System.Entity.*;
import com.Project.Inventory.and.Sales.Management.System.Repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@Service
@Transactional
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleItemService saleItemService;
    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    private final InvoiceEmailLogService invoiceEmailLogService;

    public SaleService(SaleRepository saleRepository,
                       SaleItemService saleItemService,
                       ProductRepository productRepository,
                       DiscountRepository discountRepository,
                       InvoiceEmailLogService invoiceEmailLogService) {
        this.saleRepository = saleRepository;
        this.saleItemService = saleItemService;
        this.productRepository = productRepository;
        this.discountRepository = discountRepository;
        this.invoiceEmailLogService = invoiceEmailLogService;
    }

    public void createSale(SaleRequestDTO request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Sale must contain at least one item.");
        }

        // Calculate total
        double total = request.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // Apply discount if present
        if (request.getDiscountId() != null) {
            Discount discount = discountRepository.getById(request.getDiscountId());
            if (discount != null && discount.getStartDate().isBefore(ChronoLocalDate.from(LocalDateTime.now()))
                    && discount.getEndDate().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) {
                total = total - (total * discount.getPercentage() / 100.0);
            }
        }

        // Create and save Sale
        Sale sale = new Sale();
        sale.setCustomerId(request.getCustomerId());
        sale.setDiscountId(request.getDiscountId());
        sale.setTotalAmount(total);
        sale.setSaleDate(request.getSaleDate() != null ? request.getSaleDate() : LocalDateTime.now());

        saleRepository.save(sale);



        // Save each sale item
        for (SaleItem item : request.getItems()) {
            item.setSaleId(sale.getId());
            saleItemService.addSaleItem(item); // handles product stock update
        }


        InvoiceEmailLog log = new InvoiceEmailLog();
        log.setSaleId(sale.getId());
        log.setEmailTo("nasifsadnanc1@gmail.com");
        log.setSentAt(LocalDateTime.now());
        invoiceEmailLogService.saveEmailLog(log);
    }

    public List<Sale> getAllSales() {
        return saleRepository.getAll();
    }

    public Sale getSaleById(int id) {
        return saleRepository.getById(id);
    }

    public void deleteSale(int id) {
        // 1. Get all sale items for this sale
        List<SaleItem> saleItems = saleItemService.getItemsBySaleId(id);

        // 2. Restore stock for each product
        for (SaleItem item : saleItems) {
            var product = productRepository.getById(item.getProductId());
            if (product != null) {
                product.setQuantity(product.getQuantity() + item.getQuantity());
                product.setAvailable(product.getQuantity() > 0);
                productRepository.update(product);
            }
        }

        // 3. Delete sale items
        for (SaleItem item : saleItems) {
            saleItemService.deleteSaleItem(item.getId());
        }

        // 4. Finally delete the sale
        saleRepository.delete(id);
    }
}
