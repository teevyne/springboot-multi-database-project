//package com.multidb.iwise.model.objectmodels;
//
//import com.multidb.iwise.model.document.bank.Account;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import java.util.List;
//
//@NoArgsConstructor
//@Data
//@ToString
//public class AccountHolderModel {
//
//    private String firstName;
//
//    private String lastName;
//
//    private String phoneNumber;
//
//    private String emailAddress;
//
//    private List<Account> accounts;
//}


package com.multidb.iwise.model.objectmodels;

import com.multidb.iwise.model.objectmodels.account.AccountModel;
import com.multidb.iwise.model.objectmodels.insurance.InsuranceAccountModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@ToString
public class AccountHolderModel {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String emailAddress;

    private List<AccountModel> accounts;

    private List<InsuranceAccountModel> insuranceAccounts;
}