package com.multidb.iwise.model.objectmodels;

import com.multidb.iwise.model.document.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.List;

@NoArgsConstructor
@ToString
@Data
public class AccountModel {

    private String firstName;

    private String lastName;

    private String email;

    private String accountNumber;

    private String bankVN;

    private String currency;

    private Double accountBalance;

    private String accountType;

    private String bankInstitution;

    @DBRef
    private List<Transaction> transactions;
}
