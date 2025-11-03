package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID groupId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private UUID payerId;

    @Column
    private int categoryId;  // futura chave estrangeira

    public Expense() {
        this.date = LocalDateTime.now();
    }

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
