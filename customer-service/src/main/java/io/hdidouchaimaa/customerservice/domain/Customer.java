package io.hdidouchaimaa.customerservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public static Customer create(final String name, final String email) {
        Customer customer = new Customer();
        customer.name = name;
        customer.email = email;
        return customer;
    }
}
