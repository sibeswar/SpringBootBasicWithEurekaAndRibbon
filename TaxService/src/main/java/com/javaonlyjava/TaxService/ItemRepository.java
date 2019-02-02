package com.javaonlyjava.TaxService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
	Item findByitemName(String iName);

}
