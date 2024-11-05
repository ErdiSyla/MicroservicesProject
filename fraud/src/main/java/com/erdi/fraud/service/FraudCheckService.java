package com.erdi.fraud.service;
import java.time.LocalDateTime;

import com.erdi.fraud.model.FraudCheckHistory;
import com.erdi.fraud.repo.FraudCheckHistoryRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
        FraudCheckHistory.builder()
        .isFraudster(false)
        .customerId(customerId)
        .dateWhenChecked(LocalDateTime.now())
        .build());
        return false;
    }

}
