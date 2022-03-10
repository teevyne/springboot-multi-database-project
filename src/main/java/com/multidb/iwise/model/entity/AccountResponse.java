package com.multidb.iwise.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {

    private String bankName;

    private double accountBalance;

    private String accountType;

}
