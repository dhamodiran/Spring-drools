package com.dhamo.spring.drools.model;

import java.util.Date;

public enum CustomerType {
    LOYAL, NEW, DISSATISFIED;


    public String getValue() {
        return this.toString();

    }
}