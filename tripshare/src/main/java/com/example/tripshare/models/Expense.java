package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Expense {
    private UUID id;
    private UUID groupId;
    private String description;
    private LocalDateTime date;
    private UUID payerId;
    private int categoryId;  // futura chave estrangeira

    public Expense(UUID id, UUID groupId, String description, LocalDateTime date, UUID payerId, int categoryId) {
        this.id = UUID.randomUUID();
        this.groupId = groupId;
        this.description = description;
        this.date = LocalDateTime.now();
        this.payerId = payerId;
        this.categoryId = categoryId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public void setPayerId(UUID payerId) {
        this.payerId = payerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
