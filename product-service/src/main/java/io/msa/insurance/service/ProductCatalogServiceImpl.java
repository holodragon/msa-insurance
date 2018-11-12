package io.msa.insurance.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.msa.insurance.model.Product;
import io.msa.insurance.model.ProductRepository;
import io.msa.insurance.rest.ProductCatalogEndpoint;

@Component
public class ProductCatalogServiceImpl implements ProductCatalogService {
	private static final Logger log = LoggerFactory.getLogger(ProductCatalogServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(Long itemId) {
		try {
			log.debug(Thread.currentThread().getId() + " Method getProduct " + itemId);
			return productRepository.findByItemId(itemId);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			log.debug(Thread.currentThread().getId() + " Method getAllProducts");
			return productRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

}
