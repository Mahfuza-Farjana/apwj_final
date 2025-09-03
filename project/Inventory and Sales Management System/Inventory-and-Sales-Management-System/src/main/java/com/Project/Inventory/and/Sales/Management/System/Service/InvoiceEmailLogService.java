package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.InvoiceEmailLog;
import com.Project.Inventory.and.Sales.Management.System.Repository.InvoiceEmailLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceEmailLogService {

    private final InvoiceEmailLogRepository invoiceEmailLogRepository;

    public InvoiceEmailLogService(InvoiceEmailLogRepository invoiceEmailLogRepository) {
        this.invoiceEmailLogRepository = invoiceEmailLogRepository;
    }


    public void saveEmailLog(InvoiceEmailLog log) {
        if (log == null) {
            throw new IllegalArgumentException("InvoiceEmailLog cannot be null");
        }
        if (log.getSaleId() == null) {
            throw new IllegalArgumentException("Sale ID must be provided");
        }
        if (log.getEmailTo() == null || log.getEmailTo().isBlank()) {
            throw new IllegalArgumentException("Recipient email must be provided");
        }
        if (log.getSentAt() == null) {
            throw new IllegalArgumentException("Sent timestamp must be provided");
        }
        invoiceEmailLogRepository.save(log);
    }


    public List<InvoiceEmailLog> getEmailLogsBySaleId(int saleId) {
        return invoiceEmailLogRepository.getBySaleId(saleId);
    }
}
