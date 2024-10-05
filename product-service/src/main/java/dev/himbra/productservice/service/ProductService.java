package dev.himbra.productservice.service;

import dev.himbra.productservice.Repository.ProductRepository;
import dev.himbra.productservice.dto.ProductRequest;
import dev.himbra.productservice.dto.ProductResponse;
import dev.himbra.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public Product createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return product;
    }
    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().
                stream().map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(), product.getPrice())
                ).toList();
    }
}
