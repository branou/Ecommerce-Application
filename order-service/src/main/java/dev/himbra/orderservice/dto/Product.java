package dev.himbra.orderservice.dto;

import java.math.BigDecimal;

public record Product(
        String productCode,
        String productName,
        BigDecimal price,
        int quantity
) {
}
