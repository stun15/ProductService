package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//localhost:8080/products
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);
    }

    
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //createProduct
    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product)
    }
    //deleteProduct
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id)
    }
}
