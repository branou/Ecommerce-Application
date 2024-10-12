package dev.himbra.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
         Integer id,
         String orderNumber,
         BigDecimal price,
         List<Product> products,
         int quantity
) {
}
