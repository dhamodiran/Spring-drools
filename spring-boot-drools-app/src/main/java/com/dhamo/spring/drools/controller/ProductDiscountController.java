package com.dhamo.spring.drools.controller;

import com.dhamo.spring.drools.model.OrderDiscount;
import com.dhamo.spring.drools.model.OrderRequest;
import com.dhamo.spring.drools.model.Product;
import com.dhamo.spring.drools.service.ProductDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDiscountController {

    @Autowired
    ProductDiscountService productDiscountService;

    @PostMapping("/get-product-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody Product product) {
        OrderDiscount discount = productDiscountService.getDiscount(product);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

}
