package com.desarrollo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.entities.Product;
import com.desarrollo.services.ProductService;

@RestController
public class ProductRESTController {
     @Autowired
     private ProductService productService;

   @GetMapping("/productslist")
    public List<Product> productlist() {
        System.out.println("Returning products:");
        return (List<Product>) productService.listAllProducts();
    } 
   
   @PostMapping("/newproduct")
   public ResponseEntity saveProduct(@RequestBody Product product) {
       productService.saveProduct(product);
       System.out.println(">>> Save product");
       return new ResponseEntity<>("Producto creado", HttpStatus.OK);
   } 
}
