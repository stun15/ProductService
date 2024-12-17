package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//localhost:8080/products
@RestController //This controller is going to REST HTTP API's
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    //localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);
    }

    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public Product replaceProduct(Long id,@RequestBody Product product) {
        return productService.replaceProductById(id,product);
    }

    //createProduct
    //deleteProduct
    //updateProduct -> Partial Update (PATCH)
    //replaceProduct -> Replace (PUT)
}
