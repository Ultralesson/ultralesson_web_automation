package com.ultralesson.training.web.models;

import lombok.Data;

@Data
public class Address {
    private String firstName;
    private String lastName;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
