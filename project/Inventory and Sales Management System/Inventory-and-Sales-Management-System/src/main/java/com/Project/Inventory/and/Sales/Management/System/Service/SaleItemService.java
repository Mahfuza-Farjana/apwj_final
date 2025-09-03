package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.SaleItem;
import com.Project.Inventory.and.Sales.Management.System.Repository.SaleItemRepository;
import com.Project.Inventory.and.Sales.Management.System.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;
    private final ProductRepository productRepository;

    public SaleItemService(SaleItemRepository saleItemRepository, ProductRepository productRepository) {
        this.saleItemRepository = saleItemRepository;
        this.productRepository = productRepository;
    }

    // Get all sale items by saleId
    public List<SaleItem> getItemsBySaleId(int saleId) {
        return saleItemRepository.getBySaleId(saleId);
    }

    // Add a sale item with validation and stock update
    public void addSaleItem(SaleItem saleItem) {
        // Check if product exists
        var product = productRepository.getById(saleItem.getProductId());
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + saleItem.getProductId());
        }

        // Check if enough stock is available
        if (product.getQuantity() < saleItem.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
        }

        // Update product stock
        product.setQuantity(product.getQuantity() - saleItem.getQuantity());
        product.setAvailable(product.getQuantity() > 0);
        productRepository.update(product);

        // Save sale item
        saleItemRepository.save(saleItem);
    }

    // Update sale item quantity and price, adjust stock accordingly
    public void updateSaleItem(SaleItem saleItem) {
        SaleItem existingItem = saleItemRepository.getBySaleId(saleItem.getSaleId())
                .stream()
                .filter(item -> item.getId().equals(saleItem.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("SaleItem not found with id: " + saleItem.getId()));

        var product = productRepository.getById(saleItem.getProductId());
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + saleItem.getProductId());
        }

        int quantityDiff = saleItem.getQuantity() - existingItem.getQuantity();

        if (quantityDiff > 0 && product.getQuantity() < quantityDiff) {
            throw new IllegalArgumentException("Insufficient stock to increase quantity for product: " + product.getName());
        }

        // Update product stock based on quantity difference
        product.setQuantity(product.getQuantity() - quantityDiff);
        product.setAvailable(product.getQuantity() > 0);
        productRepository.update(product);

        // Update sale item
        saleItemRepository.update(saleItem);
    }

    // Delete sale item and restore product stock
    public void deleteSaleItem(int saleItemId) {
        // Fetch the sale item to get productId and quantity
        SaleItem saleItem = saleItemRepository.getAll()
                .stream()
                .filter(item -> item.getId().equals(saleItemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("SaleItem not found with id: " + saleItemId));

        var product = productRepository.getById(saleItem.getProductId());
        if (product != null) {
            product.setQuantity(product.getQuantity() + saleItem.getQuantity());
            product.setAvailable(product.getQuantity() > 0);
            productRepository.update(product);
        }

        saleItemRepository.delete(saleItemId);
    }
}
