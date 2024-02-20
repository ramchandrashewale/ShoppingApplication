package com.example.ProductSearch.repository;

import com.example.ProductSearch.entity.ProductSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<ProductSearch,String> {


    List<ProductSearch> findByProductName(String searchText);
}
