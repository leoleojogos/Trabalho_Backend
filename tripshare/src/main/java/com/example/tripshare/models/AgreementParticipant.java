package com.example.tripshare.models;

import java.util.UUID;

public class AgreementParticipant {
    private UUID agreementId;
    private UUID userId;
    private double amountPaid;
    private double amountOwed;

    public AgreementParticipant(UUID agreementId, UUID userId, double amountPaid, double amountOwed) {
        this.agreementId = agreementId;
        this.userId = userId;
        this.amountPaid = amountPaid;
        this.amountOwed = amountOwed;
    }

    public UUID getAgreementId() {
        return agreementId;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
