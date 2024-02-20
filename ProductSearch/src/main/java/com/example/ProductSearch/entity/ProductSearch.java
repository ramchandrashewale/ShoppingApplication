package com.example.ProductSearch.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"_class"})
@Data
public class ProductSearch {
    @Id
    private Integer productId;

    @Field(type = FieldType.Text)
    private String productName;

    @Field(type = FieldType.Text)
    private String productDescription;

    @Field(type = FieldType.Float)
    private Double price;


    @Field(type = FieldType.Text)
    private String userName;

//    private List<Image> images;
//
//
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//        public static class Image{
//          private   String url;
//        }

}
