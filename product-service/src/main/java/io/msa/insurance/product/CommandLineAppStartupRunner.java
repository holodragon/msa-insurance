package io.msa.insurance.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.msa.insurance.product.command.ProductCommandController;
import io.msa.insurance.product.domain.Product;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

	@Autowired
	private ProductCommandController productCommandController;

	@Value("${product.json.load}")
//	private Resource loadFile;
	private String loadFile;

	@Override
	public void run(String... args) throws Exception {
//		Reader in = new InputStreamReader(loadFile.getInputStream(), "UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Product>> mapType = new TypeReference<List<Product>>() {
		};
		logger.info("File:" + loadFile);
		InputStream inputStream = TypeReference.class.getResourceAsStream(loadFile);
		try {
			List<Product> products = mapper.readValue(inputStream, mapType);
			for (Product prd : products) {
				logger.info("INX: " + prd.getId());
				logger.info("PRODUCT ID: " + prd.getProductId());
			}
			productCommandController.addProducts(products);
			logger.info("Products Saved!");
		} catch (IOException e) {
//			logger.info("Unable to save Products: " + e.getMessage());
			e.printStackTrace();
		}
	}
}