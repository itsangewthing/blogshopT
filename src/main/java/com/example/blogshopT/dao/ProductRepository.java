package com.example.blogshopT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
// import com.luv2code.ecommerce.entity.Product;

import com.example.blogshopT.entity.Product;

            //js running on web browser
@CrossOrigin("http://localhost:4200")
// @CrossOrigin("http://localhost:4200", "http://www.webbrowser.com")
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
