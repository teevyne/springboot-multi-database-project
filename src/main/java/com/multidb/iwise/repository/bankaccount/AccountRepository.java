package com.multidb.iwise.repository.bankaccount;

import com.multidb.iwise.model.document.bank.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    public List<Account> findAccountByEmail(String email);

    public boolean existsByBankVN(String bankVN);

//    public boolean existsByEmailAddress(String email);
//    public boolean existsByBankVN(String email);

    public void deleteAccountByEmail(String email);

    List<Account> findByBankVN(String accountNumber);
}
