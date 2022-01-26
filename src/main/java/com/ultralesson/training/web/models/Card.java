package com.ultralesson.training.web.models;

import lombok.Data;

@Data
public class Card {
    private long number;
    private String name;
    private Expiry expiry;
    private int securityCode;


    @Data
    private class Expiry {
        private int month;
        private int year;
    }
}
