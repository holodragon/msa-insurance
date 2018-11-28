package io.msa.insurance.product.command.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.msa.insurance.product.command.ProductCommandController;
import io.msa.insurance.product.domain.Product;

@RestController
@RequestMapping("/product")
public class ProductCatalogEndpoint {

	private static final Logger log = LoggerFactory.getLogger(ProductCatalogEndpoint.class);

	@Autowired
	private ProductCommandController productCommandController;

	@GetMapping("/")
	public Page<Product> list() {
		log.debug(Thread.currentThread().getId() + " Method list.");
		return productCommandController.getAllProducts();
	}

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable String productId) {
		log.debug(Thread.currentThread().getId() + " Method getProductById " + productId);
		return productCommandController.getProduct(productId);
	}

	@PutMapping("/")
	public Product addProduct(@Valid @RequestBody Product product) {
		log.debug(Thread.currentThread().getId() + " Method addProduct " + product.getName());
		return productCommandController.addProduct(product);
	}

	@PostMapping("/")
	public Product updateProduct(@Valid @RequestBody Product product) {
		log.debug(Thread.currentThread().getId() + " Method updateProduct " + product.getName());
		return productCommandController.updateProduct(product);
	}

	@GetMapping("/findByName")
	public Product getProductByName(@RequestParam("name") String name) {
		log.debug(Thread.currentThread().getId() + " Method getProductByName " + name);
		return productCommandController.getProductByName(name);
	}

}
