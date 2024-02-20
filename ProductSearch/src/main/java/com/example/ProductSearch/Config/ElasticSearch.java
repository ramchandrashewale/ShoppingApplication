package com.example.ProductSearch.Config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.example.ProductSearch.Service.ProductService;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;


@EnableElasticsearchRepositories
@Configuration
public class ElasticSearch {
    @Bean
    public RestClient create(){
        RestClient restClient=RestClient.builder(HttpHost.create("localhost:9200")).build();
        return restClient;
    }
    public ElasticsearchClient elasticsearchClient(){

        ElasticsearchTransport transport =new RestClientTransport(
                create(), new JacksonJsonpMapper());

        ElasticsearchClient client=new ElasticsearchClient(transport);

        try {
            CreateIndexResponse createIndexResponse = client.indices().create(r -> r.index("product"));
            if (createIndexResponse.acknowledged()) {
                System.out.println("Product index created");
            }
        } catch (IOException e) {
            System.err.println("Error creating product index: " + e.getMessage());
        }

        return  client;
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:8080/rating").build();
    }

}


