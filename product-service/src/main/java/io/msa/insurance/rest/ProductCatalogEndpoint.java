package io.msa.insurance.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.msa.insurance.model.Product;
import io.msa.insurance.service.ProductCatalogService;

@RestController
@RequestMapping("/products")
public class ProductCatalogEndpoint {

	private static final Logger log = LoggerFactory.getLogger(ProductCatalogEndpoint.class);

	@Autowired
	private ProductCatalogService productCatalogService;

	@GetMapping("/")
	public List<Product> list() {
		log.debug(Thread.currentThread().getId() + " Method list.");
		return productCatalogService.getAllProducts();
	}

	@GetMapping("/{itemId}")
	public Product getProductById(@PathVariable Long itemId) {
		log.debug(Thread.currentThread().getId() + " Method getProductById " + itemId);
		return productCatalogService.getProduct(itemId);
	}

}
