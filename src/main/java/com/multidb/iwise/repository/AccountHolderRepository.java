package com.multidb.iwise.repository;

import com.multidb.iwise.model.entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    public boolean existsByEmailAddress(String email);

//    public List<AccountHolder> findByEmailAddress(String email);

    AccountHolder findByEmailAddress(String email);

    public void deleteByEmailAddress(String email);
}
