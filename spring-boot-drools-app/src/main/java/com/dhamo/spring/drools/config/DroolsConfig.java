package com.dhamo.spring.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DroolsConfig {
 private static final String RULES_ORDER_DISCOUNT_XLS = "rules/customer-rules.xlsx";
 private static final String RULES_PRODUCT_DISCOUNT_XLS = "rules/rules1.xlsx";

 private static final KieServices kieServices = KieServices.Factory.get();

 @Bean
 public KieContainer kieContainer() {

  KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
  List<String> list = Arrays.asList(RULES_ORDER_DISCOUNT_XLS,RULES_PRODUCT_DISCOUNT_XLS);
  list.forEach(e-> kieFileSystem.write(ResourceFactory.newClassPathResource(e, getClass())));
  //Resource dt = ResourceFactory.newClassPathResource(RULES_ORDER_DISCOUNT_XLS, getClass());
  //KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);

  //Resource dt1 = ResourceFactory.newClassPathResource(RULES_PRODUCT_DISCOUNT_XLS, getClass());
  //kieFileSystem = kieServices.newKieFileSystem().write(dt1);

  KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
  kieBuilder.buildAll();
  KieModule kieModule = kieBuilder.getKieModule();
  KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
  return kieContainer;
 }
}