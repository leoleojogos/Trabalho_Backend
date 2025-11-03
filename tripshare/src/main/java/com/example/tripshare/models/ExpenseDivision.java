package com.example.tripshare.models;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "expense_divisions")
public class ExpenseDivision {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID expenseId;

    @Column(nullable = false)
    private UUID participantId;

    @Column(nullable = false)
    private double amountOwed;

    public ExpenseDivision() {}

    public ExpenseDivision(UUID id, UUID expenseId, UUID participantId, double amountOwed) {
        this.id = id;
        this.expenseId = expenseId;
        this.participantId = participantId;
        this.amountOwed = amountOwed;
    }

    public UUID getId() {
        return id;
    }

    public UUID getExpenseId() {
        return expenseId;
    }

    public UUID getParticipantId() {
        return participantId;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
