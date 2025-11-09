package com.example.tripshare.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripshare.models.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{
    
}