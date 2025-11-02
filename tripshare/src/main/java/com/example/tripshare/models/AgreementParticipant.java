package com.example.tripshare.models;

import java.util.UUID;

public class AgreementParticipant {
    private UUID agreementId;
    private UUID participantId;
    private double amountPaid;
    private double amountOwed;

    public AgreementParticipant(UUID agreementId, UUID participantId, double amountPaid, double amountOwed) {
        this.agreementId = agreementId;
        this.participantId = participantId;
        this.amountPaid = amountPaid;
        this.amountOwed = amountOwed;
    }

    public UUID getAgreementId() {
        return agreementId;
    }

    public UUID getParticipantId() {
        return participantId;
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
