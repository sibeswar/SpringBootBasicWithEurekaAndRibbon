package com.javaonlyjava.paymentservice;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class PaymentServiceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	  @Autowired
	  private PaymentServiceProxy proxy;

	  @GetMapping("/payemt-service/item/{itemName}/price/{itemPrice}/quantity/{quantity}")
	  public PaymentServiceBean convertCurrency(@PathVariable String itemName,@PathVariable BigDecimal itemPrice,@PathVariable BigDecimal quantity) {

	    Map<String, String> uriVariables = new HashMap<>();
	    uriVariables.put("item", itemName);

	    ResponseEntity<PaymentServiceBean> responseEntity = new RestTemplate().getForEntity(
	        "http://localhost:8000/tax-finder/item/{item}", PaymentServiceBean.class,
	        uriVariables);

	    PaymentServiceBean response = responseEntity.getBody();
	    
	    PaymentServiceBean paymentServiceResponseBean=new PaymentServiceBean();
	    paymentServiceResponseBean.setId(response.getId());
	    paymentServiceResponseBean.setItemName(itemName);
	    paymentServiceResponseBean.setQuantity(quantity);
	    paymentServiceResponseBean.setItemPrice(itemPrice);
	    BigDecimal itemTotalPrice=itemPrice.multiply(quantity);
	    paymentServiceResponseBean.setItemTotalPrice(itemTotalPrice);
	    BigDecimal itemTaxPercentage=response.getTaxPercentage();
	    paymentServiceResponseBean.setTaxPercentage(itemTaxPercentage);
	    BigDecimal itemTotalPriceWithTax=(itemTotalPrice.multiply(itemTaxPercentage));
	    paymentServiceResponseBean.setItemTotalPriceWithTax(itemTotalPriceWithTax);
	    paymentServiceResponseBean.setPort(response.getPort());
	    
	    return paymentServiceResponseBean;
	    
	  }

	  @GetMapping("/payemt-service-feign/item/{itemName}/price/{itemPrice}/quantity/{quantity}")
	  public PaymentServiceBean convertCurrencyFeign(@PathVariable String itemName,@PathVariable BigDecimal itemPrice,@PathVariable BigDecimal quantity) {

		PaymentServiceBean response = proxy.retrieveItemTaxValue(itemName);

		PaymentServiceBean paymentServiceResponseBean=new PaymentServiceBean();
	    paymentServiceResponseBean.setId(response.getId());
	    paymentServiceResponseBean.setItemName(itemName);
	    paymentServiceResponseBean.setQuantity(quantity);
	    paymentServiceResponseBean.setItemPrice(itemPrice);
	    BigDecimal itemTotalPrice=itemPrice.multiply(quantity);
	    paymentServiceResponseBean.setItemTotalPrice(itemTotalPrice);
	    BigDecimal itemTaxPercentage=response.getTaxPercentage();
	    paymentServiceResponseBean.setTaxPercentage(itemTaxPercentage);
	    BigDecimal itemTotalPriceWithTax=(itemTotalPrice.multiply(itemTaxPercentage));
	    paymentServiceResponseBean.setItemTotalPriceWithTax(itemTotalPriceWithTax);
	    paymentServiceResponseBean.setPort(response.getPort());
	    
	    return paymentServiceResponseBean;
	  }

}
