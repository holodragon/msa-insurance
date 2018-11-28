package io.msa.insurance.product;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mongo")
// Custom Mongo configuration here
// @EnableMongoRepositories("com.sogilis.example.springbootjpamongo")
// @EnableMongoAuditing
public class MongoConfiguration {
}