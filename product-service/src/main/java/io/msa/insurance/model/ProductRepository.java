package io.msa.insurance.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByName(String name);
	
	public Product findByItemId(Long itemId);
}
