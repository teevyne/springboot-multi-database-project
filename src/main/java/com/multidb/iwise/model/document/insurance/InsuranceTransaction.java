package com.multidb.iwise.model.document.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Document(collection = "insurance-transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String insuranceAccountNumber;

    private String transactionType;

    private Date transactionDate;

    private String narration;

    private Double amount;

    private String category;
}