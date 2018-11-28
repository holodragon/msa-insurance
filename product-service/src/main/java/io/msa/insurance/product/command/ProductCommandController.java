package io.msa.insurance.product.command;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import io.msa.insurance.product.domain.Product;
import io.msa.insurance.product.domain.ProductRepository;

@Component
public class ProductCommandController {
	private static final Logger log = LoggerFactory.getLogger(ProductCommandController.class);

	@Autowired
	private ProductRepository productRepository;

	public Product getProduct(String productId) {
		try {
			log.debug(Thread.currentThread().getId() + " Method getProduct " + productId);
			return productRepository.findByProductId(productId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Product getProductByName(String name) {
		try {
			log.debug(Thread.currentThread().getId() + " Method getProductByName " + name);
			return productRepository.findByName(name);
		} catch (Exception e) {
			throw e;
		}
	}

	public Page<Product> getAllProducts() {
		try {
			log.debug(Thread.currentThread().getId() + " Method getAllProducts");
			Sort sort = new Sort(Direction.DESC, "id");
			Pageable pageable = new PageRequest(0, 15, sort);
			return productRepository.findAll(pageable);
		} catch (Exception e) {
			throw e;
		}
	}

	public Product addProduct(Product product) {
		try {
			log.debug(Thread.currentThread().getId() + " Method addProduct");
			return productRepository.insert(product);
		} catch (Exception e) {
			throw e;
		}
	}

	public Product updateProduct(Product product) {
		try {
			log.debug(Thread.currentThread().getId() + " Method updateProduct");
			Product prd = productRepository.findById(product.getId());
			prd.setName(product.getName());
			prd.setPrice(product.getPrice());
			prd.setDescription(product.getDescription());
			return productRepository.save(prd);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Product> addProducts(Iterable<Product> products) {
		try {
			log.debug(Thread.currentThread().getId() + " Method addProducts");
			return productRepository.insert(products);
		} catch (Exception e) {
			throw e;
		}
	}

}
