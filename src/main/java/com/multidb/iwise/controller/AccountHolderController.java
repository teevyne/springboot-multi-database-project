package com.multidb.iwise.controller;

import com.multidb.iwise.model.objectmodels.AccountHolderModel;
import com.multidb.iwise.model.objectmodels.AccountModel;
import com.multidb.iwise.service.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    @RequestMapping(value = "createresource", method = RequestMethod.POST)
    public String createResource(@RequestBody AccountHolderModel accountHolderModel, AccountModel accountModel){
        return accountHolderService.createResource(accountHolderModel, accountModel);
    }
}
