package com.example.ProductSearch.Service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.ProductSearch.dto.ProductEvent;
import com.example.ProductSearch.entity.Product;
import com.example.ProductSearch.entity.ProductSearch;
import com.example.ProductSearch.repository.ProductRepository;
import com.example.ProductSearch.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ElasticsearchClient client;
    @Autowired
    private ProductSearchRepository productSearchRepositoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WebClient webClient;

    @KafkaListener(topics = "product-added", groupId = "search_service")
    public void addProduct(ProductEvent productEvent){
        Product product=productRepository.findById(productEvent.getProductId()).orElseThrow();

        ProductSearch productSearch=ProductSearch.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .productDescription(product.getProductDescription())
                .userName(product.getUserName())
                .build();
        productSearchRepositoryRepository.save(productSearch);
    }


    public List<ProductSearch> getProductByName(String productName)  {
        //trying to create match query and search it
//        try {
//            SearchResponse<Product> searchResponse = client.search(s -> s
//                    .index("product")
//                    .query(q -> q
//                            .match(t -> t
//                                    .field("productName")
//                                    .query(productName))), Product.class);
//            System.out.println(searchResponse.hits());
//            List<Hit<Product>> hits = searchResponse.hits().hits();
//
//        } catch (IOException e) {
//            // Handle the exception
//            e.printStackTrace();
//            return Collections.emptyList();
//        }

        //Directly using Spring Data elastic Search to get product by name

        List<ProductSearch> productList= productSearchRepositoryRepository.findByProductName(productName);


        //here i am making call to rating service and returning response from it

//              for(Product product:productList) {
//                String productId=  product.getProductId();
//                  AggrigatedRating aggrigatedRating = webClient.get().uri("/{productId}",productId ).retrieve().bodyToMono(AggrigatedRating.class).block();
//                   ProductRatingList productRatingList=ProductRatingList.builder()
//                           .productId(product.getProductId())
//                           .productDescription(product.getProductDescription())
//                           .aggrigatedRating(aggrigatedRating)
//                           .build();
//              }


       return productList;
    }
}
