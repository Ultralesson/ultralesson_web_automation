package com.ultralesson.training.web.models;

import lombok.Data;

@Data
public class OrderDetails {
    private String orderId;
    private Cart cartSummary;
    private Customer customerDetails;
}
