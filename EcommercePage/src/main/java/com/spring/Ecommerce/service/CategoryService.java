//package com.spring.Ecommerce.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.use.ecommerce.model.Category;
//import com.use.ecommerce.repository.CategoryRepository;
//
//import java.util.List;
//
//@Service
//public class CategoryService {
//
//  @Autowired
//  private CategoryRepository categoryRepository;
//
//  public Category saveCategory(Category category) {
//      return categoryRepository.save(category);
//  }
//
//  public List<Category> getAllCategories() {
//      return categoryRepository.findAll();
//    }
//}