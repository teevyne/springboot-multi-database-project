package com.multidb.iwise.model.objectmodels.insurance;

import com.multidb.iwise.model.document.insurance.InsuranceTransaction;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@NoArgsConstructor
@ToString
@Data
public class InsuranceAccountModel {

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
