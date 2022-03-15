package com.multidb.iwise.model.document.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Document(collection = "insurance-accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String insuranceAccountNumber;

    private String bvn;

    private String nin;

    private String currency;

    private double insuranceBalance;

    private String insuranceType;

    private String insuranceCompany;

    private String insurancePolicyNumber;

    @DBRef(lazy = true)
    private List<InsuranceTransaction> insuranceTransactions;
}