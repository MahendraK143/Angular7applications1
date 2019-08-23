package com.sb.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Book;
import com.sb.model.Product;
import com.sb.repository.BookRepository;
import com.sb.repository.ProductRepository;

@RestController
@RequestMapping("/")
public class ProductController {
	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	private ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> getAllProject(Model model) {
		List<Product> products = productRepository.findAll();
		if (products != null) {
			model.addAttribute("products", products);
		}
		model.addAttribute("products", products);
		
		return products;
	}
	
	
}
