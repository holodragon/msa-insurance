/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.msa.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.example.html5.model.Member;
import org.jboss.tools.example.html5.model.Product;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class ProductServiceImpl implements ProductService {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Member> memberEventSrc;

	@Inject
	private Event<Product> productEventSrc;

	public void register(Member member) throws Exception {
		log.info("Registering " + member.getName());
		em.persist(member);
		memberEventSrc.fire(member);
	}

	@Override
	public void register(Product product) throws Exception {
		log.info("Registering Product " + product.getName());
		productEventSrc.fire(product);
	}

	@Override
	public List<Product> findAll() throws Exception {
		log.info("Find All Product ");
		List<Product> products = new ArrayList<Product>();
		for (int n = 0; n < 10; n++) {
			products.add(new Product(new Long(100000 + n), "TEST Product " + n, "Product Description " + n, 10.11 + n));

		}
		return products;
	}

	@Override
	public Product findById(Long id) throws Exception {
		return new Product(new Long(id), "TEST Product " + id, "Product Description " + id, 10.11 + id);
	}
}
