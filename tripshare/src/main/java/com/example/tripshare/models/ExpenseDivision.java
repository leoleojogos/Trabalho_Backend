package com.example.tripshare.models;

import java.util.UUID;

public class ExpenseDivision {
    private UUID id;
    private UUID expenseId;
    private UUID participantId;
    private double amountOwed;

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
