package com.example.CRM.Customer_relationship_management.service;


import java.util.List;
import com.example.CRM.Customer_relationship_management.model.Product;
import com.example.CRM.Customer_relationship_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setMadein(product.getMadein());
            existingProduct.setPrice(product.getPrice());

            repo.save(existingProduct);
        }
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}

