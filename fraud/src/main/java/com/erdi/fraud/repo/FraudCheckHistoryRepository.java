package com.erdi.fraud.repo;

import com.erdi.fraud.model.FraudCheckHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {

}
