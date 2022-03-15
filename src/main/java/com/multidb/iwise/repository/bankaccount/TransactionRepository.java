package com.multidb.iwise.repository.bankaccount;

import com.multidb.iwise.model.document.bank.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findTransactionsByAccountNumber(String accountNumber);
}

