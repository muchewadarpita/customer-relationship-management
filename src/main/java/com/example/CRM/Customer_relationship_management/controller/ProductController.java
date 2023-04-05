package com.example.CRM.Customer_relationship_management.controller;

import com.example.CRM.Customer_relationship_management.model.Product;
import com.example.CRM.Customer_relationship_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("specificProduct/{id}")
        public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/addnewproduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("updateProduct/{id}")
    public Product updateProduct (@PathVariable Long id, @RequestBody Product product ) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}







