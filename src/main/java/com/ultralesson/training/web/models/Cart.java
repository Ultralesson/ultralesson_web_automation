package com.ultralesson.training.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @Builder(toBuilder = true)
@NoArgsConstructor @AllArgsConstructor
public class Cart {
    private List<Product> products;
    private String subTotal;
    private  String coupon;
    private String couponDiscount;
    private String shipping;
    private String total;
    private ShippingMethod shippingMethod;
    private String taxes;
}
