package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Group {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int currency;  // futura api externa
    private UUID creatorId;


    public Group(UUID id, String name, String description, LocalDateTime createdAt, LocalDateTime startDate, LocalDateTime endDate, int currency, UUID creatorId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.creatorId = creatorId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public UUID getCreatorId() {
        return creatorId;
    }
}
