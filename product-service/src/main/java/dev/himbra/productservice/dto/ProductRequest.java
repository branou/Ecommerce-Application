package dev.himbra.productservice.dto;

public record ProductRequest(
        String id,
        String name,
        String description,
        double price
) {
}
