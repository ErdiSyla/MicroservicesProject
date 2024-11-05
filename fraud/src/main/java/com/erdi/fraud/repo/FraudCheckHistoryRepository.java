package com.erdi.fraud.repo;

import com.erdi.fraud.model.FraudCheckHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {

}