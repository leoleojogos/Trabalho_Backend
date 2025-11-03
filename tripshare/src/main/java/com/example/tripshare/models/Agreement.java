package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID groupId;

    @Column(nullable = false)
    private UUID debtorId;

    @Column(nullable = false)
    private UUID payerId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 500)
    private String description;

    public Agreement() {
        this.date = LocalDateTime.now();
    }

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
