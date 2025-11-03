package com.example.tripshare.models;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "agreement_participants")
public class AgreementParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID agreementId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private double amountPaid;

    @Column(nullable = false)
    private double amountOwed;

    public AgreementParticipant() {}

    public AgreementParticipant(UUID agreementId, UUID userId, double amountPaid, double amountOwed) {
        this.agreementId = agreementId;
        this.userId = userId;
        this.amountPaid = amountPaid;
        this.amountOwed = amountOwed;
    }

    public UUID getId() {
        return id;
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
