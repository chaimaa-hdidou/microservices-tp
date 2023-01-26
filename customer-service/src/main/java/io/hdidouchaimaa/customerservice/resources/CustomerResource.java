package io.hdidouchaimaa.customerservice.resources;

import io.hdidouchaimaa.customerservice.command.CustomerCommand;
import io.hdidouchaimaa.customerservice.domain.Customer;
import io.hdidouchaimaa.customerservice.dto.CustomerDto;
import io.hdidouchaimaa.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerCommand command) {
        this.customerRepository.save(Customer.create(command.getName(), command.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> get(@PathVariable Long id) {
        CustomerDto customerDto = this.customerRepository.findById(id)
                .map(c -> new CustomerDto(c.getName(), c.getEmail()))
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return ResponseEntity.ok()
                .body(customerDto);
    }
}
