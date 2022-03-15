package com.multidb.iwise.repository.insurance;

import com.multidb.iwise.model.document.insurance.InsuranceAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends MongoRepository<InsuranceAccount, String> {

    List<InsuranceAccount> findByBvn(String bvn);
}
