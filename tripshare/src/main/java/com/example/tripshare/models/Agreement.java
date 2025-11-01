package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Agreement {
    private UUID id;
    private UUID groupId;
    private UUID debtorId;
    private UUID payerId;
    private double amount;
    private LocalDateTime date;
    private String description;

    public Agreement(UUID id, UUID groupId, UUID debtorId, UUID payerId, double amount, LocalDateTime date, String description) {
        this.id = id;
        this.groupId = groupId;
        this.debtorId = debtorId;
        this.payerId = payerId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public UUID getGroupIdId() {
        return groupId;
    }

    public UUID getDebtorId() {
        return debtorId;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
