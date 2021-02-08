package com.multidb.iwise.model.objectmodels;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@ToString
@Data
public class TransactionModel {

    private String accountNumber;

//    private String referenceId;

    private String transactionType;

    private Date transactionDate;

    private String narration;

    private Double amount;

    private String category;
}
