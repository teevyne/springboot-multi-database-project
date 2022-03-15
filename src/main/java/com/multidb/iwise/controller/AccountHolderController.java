package com.multidb.iwise.controller;

import com.multidb.iwise.model.document.bank.Account;
import com.multidb.iwise.model.objectmodels.AccountHolderModel;
import com.multidb.iwise.model.objectmodels.account.AccountModel;
import com.multidb.iwise.model.request.AccountRequest;
import com.multidb.iwise.service.bankaccount.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

//    @Autowired
//    AccountHolderService accountHolderService;

    @RequestMapping(value = "createresource", method = RequestMethod.POST)
    public String createResource(@RequestBody AccountHolderModel accountHolderModel, AccountModel accountModel){
        return accountHolderService.createResource(accountHolderModel);
    }

    @GetMapping("get-accounts")
    public List<Account> getAllUserAccounts(@RequestBody AccountRequest accountRequest) {
        return accountHolderService.getAllUserAccounts(accountRequest.getBvn());
    }

//    @GetMapping("get-tnxs")
//    public List<Transaction> getAllUserTxns(@RequestBody AccountRequest accountRequest) {
//        return accountHolderService.getAllUserTransactions(accountRequest.getRequest());
//    }

    @GetMapping("get-total-balance")
    public Object getAllTotalBalance(@RequestBody AccountRequest accountRequest) {
        return accountHolderService.getTotalBalance(accountRequest.getBvn());
    }

    @GetMapping("get-data")
    public Object getCustomerData(@RequestBody AccountRequest accountRequest) {
        return accountHolderService.getAllData(accountRequest.getBvn());
    }
}