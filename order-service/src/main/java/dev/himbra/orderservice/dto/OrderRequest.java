package dev.himbra.orderservice.dto;

public record OrderRequest(
         Integer id,
         String orderNumber,
         double price,
         int quantity
) {
}
