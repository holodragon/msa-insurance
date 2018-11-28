package io.msa.insurance.product.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Page<Product> findAll(Pageable pageable);

	public Product findById(String id);
	
	public Product findByProductId(String productId);
	
	public Product findByName(String name);

	public List<Product> findAll();

}
