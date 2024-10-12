package dev.himbra.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(
         Integer id,
         String orderNumber,
         BigDecimal price,
         int quantity
) {
}
