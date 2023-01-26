package io.hdidouchaimaa.inventory.resource;

import io.hdidouchaimaa.inventory.dto.ProductDto;
import io.hdidouchaimaa.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductRepository productRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        ProductDto productDto = this.productRepository.findById(id)
                .map(p -> new ProductDto(p.getName(), p.getPrice(), p.getQuantity()))
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ResponseEntity.ok()
                .body(productDto);
    }
}
