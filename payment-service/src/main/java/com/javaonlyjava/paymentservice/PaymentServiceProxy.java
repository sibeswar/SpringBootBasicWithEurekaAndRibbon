package com.javaonlyjava.paymentservice;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="tax-service")
@RibbonClient(name="tax-service")
public interface PaymentServiceProxy {
	@GetMapping("/tax-finder/item/{itemName}")
	  public PaymentServiceBean retrieveItemTaxValue(@PathVariable("itemName") String itemName);

}
