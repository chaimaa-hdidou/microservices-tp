package io.hdidouchaimaa.billing.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "billing")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
