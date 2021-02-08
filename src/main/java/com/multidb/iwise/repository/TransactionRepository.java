package com.multidb.iwise.repository;

import com.multidb.iwise.model.document.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

//    public List<Transaction> findTransactionsByEmail(String email);
}

