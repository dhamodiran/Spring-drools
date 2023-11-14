package com.dhamo.spring.drools.controller;

import com.dhamo.spring.drools.model.OrderDiscount;
import com.dhamo.spring.drools.model.OrderRequest;
import com.dhamo.spring.drools.service.OrderDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDiscountController {
 
    @Autowired
    private OrderDiscountService orderDiscountService;
 
    @PostMapping(value = "/get-discount",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

    @GetMapping( value = "/")
    public String greetingMsg(@RequestHeader MultiValueMap<String, String> headers){

        System.out.println("HEADER:"+headers.get("msg1"));
        headers.forEach((k,v)-> System.out.println("Key:"+k+" Value:"+v));
        return "Spring Boot with Drools";
    }

    @PostMapping(value = "/get-discount1",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getDiscount1(@RequestBody String xmlPayload) {
       // OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);

        return new ResponseEntity<>(xmlPayload, HttpStatus.OK);
    }

}