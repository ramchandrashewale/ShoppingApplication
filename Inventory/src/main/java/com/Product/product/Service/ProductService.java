package com.Product.product.Service;

import com.Product.product.dto.ProductEvent;
import com.Product.product.dto.ProductRequest;
import com.Product.product.entity.Product;
import com.Product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    private static final String TOPIC = "product-added"; // Kafka topic name

    @Autowired
    private KafkaTemplate<String, ProductEvent> kafkaTemplate;
    public Product addProduct(ProductRequest productRequest){


        Product product=Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .userName(productRequest.getUserName())
                .build();

//        List<ProductImage> productImages=productRequest.getProductImages();
//        if(!productImages.isEmpty()) {
//            for (ProductImage productImage : productImages) {
//                ProductImage productimage = ProductImage.builder()
//                        .url(productImage.getUrl())
//                        .product(product)
//                        .build();
//                product.getProductImages().add(productimage);
//
//            }
//        }
            Product savedProduct = productRepository.save(product);

            kafkaTemplate.send("product-added",new ProductEvent(savedProduct.getProductId(),"product-added"));
            return savedProduct;

    }
    public Page<Product> getProductByUser(String userName,int pageNumber,int pageSize){
        PageRequest pageRequest=PageRequest.of(pageNumber,pageSize);
        Page<Product> listProduct=productRepository.findByUserName(pageRequest,userName);
        return listProduct;
    }
}
