package com.multidb.iwise.service.bankaccount;

import com.multidb.iwise.model.document.bank.Transaction;
import com.multidb.iwise.repository.bankaccount.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAccountTransactions(String accountNumber) {

        List<Transaction> accountTransactionList = transactionRepository.findTransactionsByAccountNumber(accountNumber);

        if (accountTransactionList == null || accountTransactionList.size() == 0) {
            return null;
        }

        return accountTransactionList;
    }
}
