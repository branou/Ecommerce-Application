package dev.himbra.orderservice.model;

import dev.himbra.orderservice.dto.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderNumber;
    @Transient
    private List<Product> products;
    private BigDecimal price;
    private int quantity;
}
