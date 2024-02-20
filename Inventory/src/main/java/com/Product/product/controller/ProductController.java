package com.Product.product.controller;

import com.Product.product.Service.ProductService;
import com.Product.product.dto.ProductRequest;
import com.Product.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductRequest productRequest){

        return productService.addProduct(productRequest);
    }
    @GetMapping
    public Page<Product> getProductByUser(@RequestParam(value = "userName")String userName,
                                          @RequestParam(value = "pageNo",required = false,defaultValue = "0")int pageNo,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "3")int pageSize){
       return productService.getProductByUser(userName,pageNo,pageSize);
    }

}
