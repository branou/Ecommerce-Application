package dev.himbra.inventoryservice.controller;

import dev.himbra.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping ("/checkStock/{productCode}/{quantity}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean isInStock(@PathVariable String productCode,@PathVariable int quantity){
        return inventoryService.isInStock(productCode,quantity);
    }
}
