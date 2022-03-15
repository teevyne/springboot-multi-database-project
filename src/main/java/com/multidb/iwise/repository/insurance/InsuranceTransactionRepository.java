package com.multidb.iwise.repository.insurance;

import com.multidb.iwise.model.document.insurance.InsuranceTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceTransactionRepository extends MongoRepository<InsuranceTransaction, String> {
}
