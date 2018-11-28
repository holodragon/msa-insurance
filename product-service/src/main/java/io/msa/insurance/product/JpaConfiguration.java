package io.msa.insurance.product;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
// Custom JPA configuration here
// @EnableJpaRepositories("com.sogilis.example.springbootjpamongo")
// @EnableJpaAuditing
public class JpaConfiguration {
}