package com.example.tripshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tripshare.models.entities.Agreement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, UUID> {
    
    List<Agreement> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT COUNT(a) FROM Agreement a WHERE a.createdAt BETWEEN :start AND :end")
    Long countByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    
    @Query("SELECT COUNT(a) FROM Agreement a WHERE a.createdAt BETWEEN :start AND :end AND a.isPaid = true")
    Long countPaidByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    
    @Query("SELECT COUNT(a) FROM Agreement a WHERE a.createdAt BETWEEN :start AND :end AND a.isPaid = false")
    Long countUnpaidByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}