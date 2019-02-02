package com.javaonlyjava.TaxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {
	@Autowired
	private Environment environment;

	@Autowired
	private ItemRepository repository;

	@GetMapping("/tax-finder/item/{itemName}")
	public Item retrieveItemTaxValue(@PathVariable String itemName) {

		Item item = repository.findByitemName(itemName);

		item.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		return item;
	}

}
