package com.multidb.iwise.service.insurance;

import com.multidb.iwise.model.document.bank.Account;
import com.multidb.iwise.model.document.bank.Transaction;
import com.multidb.iwise.model.document.insurance.InsuranceAccount;
import com.multidb.iwise.model.document.insurance.InsuranceTransaction;
import com.multidb.iwise.model.entity.AccountHolder;
import com.multidb.iwise.model.objectmodels.AccountHolderModel;
import com.multidb.iwise.repository.AccountHolderRepository;
import com.multidb.iwise.repository.bankaccount.AccountRepository;
import com.multidb.iwise.repository.bankaccount.TransactionRepository;
import com.multidb.iwise.repository.insurance.InsuranceRepository;
import com.multidb.iwise.repository.insurance.InsuranceTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InsuranceService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private InsuranceTransactionRepository insuranceTransactionRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Transactional
    public String createInsuranceResource(AccountHolderModel accountHolderModel) {

        if (accountHolderRepository.existsByEmailAddress(accountHolderModel.getEmailAddress())) {

//            AccountHolder accountHolder = new AccountHolder();
            AccountHolder accountHolder = accountHolderRepository.findByEmailAddress(accountHolderModel.getEmailAddress());
            BeanUtils.copyProperties(accountHolderModel, accountHolder);

            try {
//                accountHolderRepository.save(accountHolder);
                accountHolderModel.getInsuranceAccounts().stream().forEach(a -> {
                    InsuranceAccount insuranceAccount = new InsuranceAccount();
                    a.setLastName(accountHolder.getLastName());
                    log.info(accountHolderModel.getAccounts().toString());
                    BeanUtils.copyProperties(a, insuranceAccount);
                    try {
                        InsuranceTransaction insuranceTransaction = new InsuranceTransaction();
                        List<InsuranceTransaction> insuranceTransactionList = new ArrayList<>();
                        a.getInsuranceTransactions().stream().forEach(t -> {
//                            t.setAccountNumber(account.getAccountNumber());
                            t.setInsuranceAccountNumber(insuranceAccount.getInsuranceAccountNumber());
                            BeanUtils.copyProperties(t, insuranceTransaction);
                            insuranceTransactionList.add(insuranceTransaction);
                            try {
//                                transactionRepository.save(transaction);
                                insuranceTransactionRepository.save(insuranceTransaction);
                            } catch (Exception e) {
                                throw e;
                            }

                        });
                        insuranceAccount.setInsuranceTransactions(insuranceTransactionList);
                        insuranceRepository.save(insuranceAccount);

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
}
