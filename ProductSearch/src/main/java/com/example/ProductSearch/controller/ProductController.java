package com.example.ProductSearch.controller;

import com.example.ProductSearch.Service.ProductService;
import com.example.ProductSearch.entity.ProductSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @PostMapping("/add")
//    public void add(@RequestBody ProductRequest productRequest){
//        productService.addProduct(productRequest);
//    }
    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductSearch> searchByName(@RequestParam (value = "productName") String productName){

            return  productService.getProductByName(productName);

    }

}
