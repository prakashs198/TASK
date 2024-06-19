package com.spring.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Ecommerce.model.Product;
import com.spring.Ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product) {
      return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
      return productRepository.findAll();
  }

  public Optional<Product> getProductById(int id) {
      return productRepository.findById(id);
  }
}