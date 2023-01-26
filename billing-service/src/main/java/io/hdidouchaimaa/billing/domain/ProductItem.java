package io.hdidouchaimaa.billing.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hdidouchaimaa.billing.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Billing billing;
    private int quantity;
    private double price;
    private double discount;
    @Transient
    private Product product;
}