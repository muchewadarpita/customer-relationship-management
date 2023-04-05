package com.example.CRM.Customer_relationship_management.repository;



import com.example.CRM.Customer_relationship_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}