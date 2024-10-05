package dev.himbra.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "product")
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;

}
