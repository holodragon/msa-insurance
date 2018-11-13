package io.msa.insurance.service;

import java.util.List;

import org.jboss.tools.example.html5.model.Product;

public interface ProductService {

	public void register(Product product) throws Exception;

	public List<Product> findAll() throws Exception;

	public Product findById(Long id) throws Exception;

}
