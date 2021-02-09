package com.multidb.iwise.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private String firstName;

    private String lastName;

    private String email;

    private String accountNumber;

    private String bankVN;

    private String currency;

    private Double accountBalance;

    private String accountType;

    private String bankInstitution;

//    @DBRef
    private List<Transaction> transactions = new ArrayList<>();
}
