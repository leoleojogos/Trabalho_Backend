package com.example.tripshare.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Table(name = "payment_splits")
@Entity
@SuperBuilder
public class PaymentSplit extends ClassificationEntity{
    
}
