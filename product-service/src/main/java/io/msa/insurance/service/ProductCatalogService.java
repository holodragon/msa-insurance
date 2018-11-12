package io.msa.insurance.service;

import java.util.List;

import io.msa.insurance.model.Product;

public interface ProductCatalogService {

	List<Product> getAllProducts();
	Product getProduct(Long itemId);

}
