package com.Project.Inventory.and.Sales.Management.System.API;

import com.Project.Inventory.and.Sales.Management.System.Entity.InvoiceEmailLog;
import com.Project.Inventory.and.Sales.Management.System.Service.InvoiceEmailLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-email-logs")
public class InvoiceEmailLogApi{

    private final InvoiceEmailLogService invoiceEmailLogService;

    public InvoiceEmailLogApi(InvoiceEmailLogService invoiceEmailLogService) {
        this.invoiceEmailLogService = invoiceEmailLogService;
    }

    // GET all email logs for a specific sale
    @GetMapping("/by-sale/{saleId}")
    public ResponseEntity<List<InvoiceEmailLog>> getLogsBySaleId(@PathVariable int saleId) {
        return ResponseEntity.ok(invoiceEmailLogService.getEmailLogsBySaleId(saleId));
    }

    // POST log a new invoice email (optional admin/manual logging)
    @PostMapping
    public ResponseEntity<String> logInvoiceEmail(@RequestBody InvoiceEmailLog log) {
        try {
            invoiceEmailLogService.saveEmailLog(log);
            return ResponseEntity.ok("Invoice email log saved successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Failed to save log: " + e.getMessage());
        }
    }
}
