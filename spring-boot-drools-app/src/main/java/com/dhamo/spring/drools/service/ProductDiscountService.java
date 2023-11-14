package com.dhamo.spring.drools.service;

import com.dhamo.spring.drools.model.OrderDiscount;
import com.dhamo.spring.drools.model.OrderRequest;
import com.dhamo.spring.drools.model.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDiscountService {
    @Autowired
    private KieContainer kieContainer;

    public OrderDiscount getDiscount(Product product) {
        OrderDiscount orderDiscount = new OrderDiscount();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        orderDiscount.setDiscount(product.getDiscount());
        System.out.println("Prduct Type:"+product.getType()+" Product Discount:"+product.getDiscount());
        return orderDiscount;
    }
}
