package io.hdidouchaimaa.billing.clients;

import io.hdidouchaimaa.billing.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {

    @GetMapping("/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
