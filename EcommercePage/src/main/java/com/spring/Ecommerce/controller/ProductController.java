package com.spring.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.Ecommerce.model.Product;
import com.spring.Ecommerce.repository.ProductRepository;


@Controller
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/products")
  public String getAllProducts(Model model) {
      List<Product> products = productRepository.findAll();
      model.addAttribute("products", products);
      return "products";
  }
  
}