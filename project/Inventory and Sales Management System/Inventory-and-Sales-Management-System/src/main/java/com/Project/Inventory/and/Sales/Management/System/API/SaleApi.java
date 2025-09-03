package com.Project.Inventory.and.Sales.Management.System.API;


import com.Project.Inventory.and.Sales.Management.System.DTO.SaleRequestDTO;
import com.Project.Inventory.and.Sales.Management.System.Entity.Sale;
import com.Project.Inventory.and.Sales.Management.System.Service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleApi {

    private final SaleService saleService;

    public SaleApi(SaleService saleService) {
        this.saleService = saleService;
    }

    // GET all sales
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    // GET sale by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable int id) {
        Sale sale = saleService.getSaleById(id);
        if (sale == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale);
    }

    // POST create a new sale (includes sale items, optional discount)
    @PostMapping
    public ResponseEntity<String> createSale(@RequestBody SaleRequestDTO saleRequestDTO) {
        try {
            saleService.createSale(saleRequestDTO);
            return ResponseEntity.ok("Sale created successfully with invoice email logged.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Sale creation failed: " + e.getMessage());
        }
    }

    // DELETE sale (restores product stock and removes items)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable int id) {
        saleService.deleteSale(id);
        return ResponseEntity.ok("Sale deleted and stock restored successfully.");
    }
}
