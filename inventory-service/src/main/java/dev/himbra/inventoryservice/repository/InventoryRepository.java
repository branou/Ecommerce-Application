package dev.himbra.inventoryservice.repository;

import dev.himbra.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    Boolean existsByProductCodeAndQuantityIsGreaterThanEqual(String productCode,int quantity);
}
