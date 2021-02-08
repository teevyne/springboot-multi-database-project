package com.multidb.iwise.service;

import com.multidb.iwise.model.document.Account;
import com.multidb.iwise.model.document.Transaction;
import com.multidb.iwise.model.entity.AccountHolder;
import com.multidb.iwise.model.objectmodels.AccountHolderModel;
import com.multidb.iwise.model.objectmodels.AccountModel;
import com.multidb.iwise.repository.AccountHolderRepository;
import com.multidb.iwise.repository.AccountRepository;
import com.multidb.iwise.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public String createResource(AccountHolderModel accountHolderModel, AccountModel accountModel) {
        if (!accountHolderRepository.existsByEmailAddress(accountHolderModel.getEmailAddress())) {
            AccountHolder accountHolder = new AccountHolder();
            BeanUtils.copyProperties(accountHolderModel, accountHolder);

            try {
                accountHolderRepository.save(accountHolder);
                accountHolderModel.getAccounts().stream().forEach(a -> {
                    Account account = new Account();
                    a.setLastName(accountHolder.getLastName());

                    log.info(accountHolderModel.getAccounts().toString());

                    BeanUtils.copyProperties(a, account);

                    try {
                        accountRepository.save(account);
                        accountModel.getTransactions().stream().forEach(t -> {
                            Transaction transaction = new Transaction();
                            t.setAccountNumber(account.getAccountNumber());
                            BeanUtils.copyProperties(t, transaction);

                            try {
                                transactionRepository.save(transaction);
                            } catch (Exception e) {
                                throw e;
                            }
                        });
                    } catch (Exception e) {
                        throw e;
                    }
                });
            } catch (Exception e) {
                throw e;
            }
            return "Resource successfully added";
        } else {
            return "Resource duplicate";
        }
    }

//    public List<AccountHolderModel> readResource() {
//        List<AccountHolderModel> holders = new ArrayList<>();
//        List<AccountHolder> holdersList = new ArrayList<>();
//
//        try {
//            holdersList = accountHolderRepository.findAll();
//        }
//        catch (Exception e) {
//            throw e;
//        }
//
//        if (holdersList.size() > 0) {
//            holdersList.stream().forEach(s -> {
//                AccountHolderModel accountHolderModel = new AccountHolderModel();
//                accountHolderModel.setFirstName(s.getFirstName());
//                accountHolderModel.setLastName(s.getLastName());
//                accountHolderModel.setEmailAddress(s.getEmailAddress());
//                accountHolderModel.setPhoneNumber(s.getPhoneNumber());
//                List<Account> accountList = new ArrayList<>();
//                List<AccountModel> accounts = new ArrayList<>();
//
//                try {
//                    accountList = accountRepository.findAccountByEmail(s.getEmailAddress());
//                } catch (Exception e) {
//                    throw e;
//                }
//
//                if (accountList.size() > 0) {
//                    accountList.stream().forEach(a -> {
//                        AccountModel accountModel = new AccountModel();
//                        accountModel.setFirstName(a.getFirstName());
//                        accountModel.setLastName(a.getLastName());
//                        accountModel.setAccountNumber(a.getAccountNumber());
//                        accountModel.setAccountBalance(a.getAccountBalance());
//                        accountModel.setAccountType(a.getAccountType());
////                        accountModel.setBankVN(a.getBankVN);
//                        accountModel.setBankInstitution(a.getBankInstitution());
//                        accountModel.setCurrency(a.getCurrency());
//                        List<Transaction> transactionList = new ArrayList<>();
//                        List<TransactionModel> transactions = new ArrayList<>();
//
//                        try {
//                            transactionList = transactionRepository.findTransactionsByEmail(accountHolderModel.getEmailAddress());
//                        }
//                        catch (Exception e) {
//                            throw e;
//                        }
//
//                        if (transactionList.size() > 0) {
//                            transactionList.stream().forEach(t -> {
//                                TransactionModel transactionModel = new TransactionModel();
//                                BeanUtils.copyProperties(t, transactionModel);
//                                transactions.add(transactionModel);
//                            });
//                        }
//                        accountModel.setTransactions(transactions);
//                        accounts.add(accountModel);
//                    });
//                }
//                accountHolderModel.setAccounts(accounts);
//                holders.add(accountHolderModel);
//            });
//        }
//        return holders;
//    }
}
