package com.multidb.iwise.controller;

import com.multidb.iwise.model.document.bank.Transaction;
import com.multidb.iwise.service.bankaccount.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("account/transactions/{accountNumber}")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
        return accountService.getAccountTransactions(accountNumber);
    }
}
