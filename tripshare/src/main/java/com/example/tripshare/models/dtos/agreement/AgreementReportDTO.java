package com.example.tripshare.models.dtos.agreement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgreementReportDTO(
    Long totalRecords,
    Long recordsInPeriod,
    BigDecimal totalAmount,
    Long paidAgreements,
    Long unpaidAgreements,
    LocalDateTime periodStart,
    LocalDateTime periodEnd
) {}
