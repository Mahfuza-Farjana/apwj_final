package com.Project.Inventory.and.Sales.Management.System.Entity;

import java.time.LocalDateTime;

public class InvoiceEmailLog {
    private Integer id;
    private Integer saleId;
    private String emailTo;
    private LocalDateTime sentAt;


    public InvoiceEmailLog() {
    }

    public InvoiceEmailLog(Integer id, Integer saleId, String emailTo, LocalDateTime sentAt) {
        this.id = id;
        this.saleId = saleId;
        this.emailTo = emailTo;
        this.sentAt = sentAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
