package dev.himbra.orderservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "inventory",url = "http://loacalhost:8082/api/inventory")
public interface InventoryClient {
    @GetMapping("/checkStock/{productCode}/{quantity}")
    Boolean isInStock(@PathVariable String productCode, @PathVariable int quantity);
}
