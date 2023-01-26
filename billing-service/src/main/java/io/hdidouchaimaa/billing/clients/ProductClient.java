package io.hdidouchaimaa.billing.clients;

import io.hdidouchaimaa.billing.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable Long id);
}
