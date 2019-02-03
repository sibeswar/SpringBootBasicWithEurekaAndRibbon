package com.javaonlyjava.paymentservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tax-service" ,url="localhost:8000")
public interface PaymentServiceProxy {
	@GetMapping("/tax-finder/item/{itemName}")
	  public PaymentServiceBean retrieveItemTaxValue(@PathVariable("itemName") String itemName);

}
