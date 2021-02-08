package com.multidb.iwise.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Document(collection = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private String accountNumber;

    private String transactionType;

    private Date transactionDate;

    private String narration;

    private Double amount;

    private String category;
}
