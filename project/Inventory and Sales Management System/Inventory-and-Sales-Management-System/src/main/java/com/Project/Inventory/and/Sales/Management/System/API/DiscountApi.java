package com.Project.Inventory.and.Sales.Management.System.API;


import com.Project.Inventory.and.Sales.Management.System.Entity.Discount;
import com.Project.Inventory.and.Sales.Management.System.Service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountApi {

    private final DiscountService discountService;

    public DiscountApi(DiscountService discountService) {
        this.discountService = discountService;
    }

    // GET all discounts (Admin)
    @GetMapping
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        return ResponseEntity.ok(discountService.getAllDiscounts());
    }

    // GET active discounts (Public)
    @GetMapping("/active")
    public ResponseEntity<List<Discount>> getActiveDiscounts() {
        return ResponseEntity.ok(discountService.getActiveDiscounts());
    }

    // GET discount by ID
    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable int id) {
        Discount discount = discountService.getDiscountById(id);
        if (discount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discount);
    }

    // POST create discount (Admin)
    @PostMapping
    public ResponseEntity<String> createDiscount(@RequestBody Discount discount) {
        try {
            discountService.createDiscount(discount);
            return ResponseEntity.ok("Discount created successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT update discount (Admin)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDiscount(@PathVariable int id, @RequestBody Discount discount) {
        discount.setId(id);
        try {
            discountService.updateDiscount(discount);
            return ResponseEntity.ok("Discount updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE discount (Admin)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscount(@PathVariable int id) {
        discountService.deleteDiscount(id);
        return ResponseEntity.ok("Discount deleted successfully.");
    }
}
