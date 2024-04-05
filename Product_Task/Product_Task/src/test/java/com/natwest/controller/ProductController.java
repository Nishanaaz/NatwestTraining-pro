package com.natwest.controller;

import com.natwest.entity.Product;
import com.natwest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com/p")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product")
    public Product postProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productRepository.findById(id).get();
    }

    @PutMapping("/product/{id}")
    public String updateProduct( @RequestBody Product product, @PathVariable int id){
        if (productRepository.existsById(id)){
            productRepository.save(product);
            return "Product has been update";
        }
        return "Product is not exists";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product has been deleted";
        }
        return "Product is not exists";
    }
}
