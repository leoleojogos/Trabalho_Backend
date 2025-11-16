package com.example.tripshare.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Table(name = "categories")
@Entity
@SuperBuilder
public class Category extends ClassificationEntity {
    
}
