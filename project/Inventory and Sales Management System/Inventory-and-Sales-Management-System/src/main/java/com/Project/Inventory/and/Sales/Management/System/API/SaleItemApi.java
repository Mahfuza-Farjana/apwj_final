package com.Project.Inventory.and.Sales.Management.System.API;


import com.Project.Inventory.and.Sales.Management.System.Entity.SaleItem;
import com.Project.Inventory.and.Sales.Management.System.Service.SaleItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale-items")
public class SaleItemApi {

    private final SaleItemService saleItemService;

    public SaleItemApi(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    // GET all items for a specific sale
    @GetMapping("/by-sale/{saleId}")
    public ResponseEntity<List<SaleItem>> getItemsBySaleId(@PathVariable int saleId) {
        return ResponseEntity.ok(saleItemService.getItemsBySaleId(saleId));
    }

    // POST add a new sale item
    @PostMapping
    public ResponseEntity<String> addSaleItem(@RequestBody SaleItem saleItem) {
        try {
            saleItemService.addSaleItem(saleItem);
            return ResponseEntity.ok("Sale item added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT update an existing sale item
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSaleItem(@PathVariable int id, @RequestBody SaleItem saleItem) {
        try {
            saleItem.setId(id);
            saleItemService.updateSaleItem(saleItem);
            return ResponseEntity.ok("Sale item updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE a sale item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSaleItem(@PathVariable int id) {
        try {
            saleItemService.deleteSaleItem(id);
            return ResponseEntity.ok("Sale item deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
