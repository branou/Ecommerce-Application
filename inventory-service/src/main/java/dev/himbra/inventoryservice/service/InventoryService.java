package dev.himbra.inventoryservice.service;

import dev.himbra.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {
    final InventoryRepository inventoryRepository;
    public Boolean isInStock(String productCode,int quantity){
        return inventoryRepository.existsByProductCodeAndQuantityIsGreaterThanEqual(productCode,quantity);
    }
}
