package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant extends User {
    @Column
    private String groupNickname;

    @Column
    private double currentBalance;

    public Participant() {}

    public Participant(UUID id, String name, String email, LocalDateTime createdAt, String groupNickname, double currentBalance) {
        super(id, name, email, createdAt);
        this.groupNickname = groupNickname;
        this.currentBalance = currentBalance;
    }

    public String getGroupNickname() {
        return groupNickname;
    }

    public void setGroupNickname(String groupNickname) {
        this.groupNickname = groupNickname;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
