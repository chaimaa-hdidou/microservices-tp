package io.hdidouchaimaa.billing.resource;

import io.hdidouchaimaa.billing.clients.CustomerClient;
import io.hdidouchaimaa.billing.clients.ProductClient;
import io.hdidouchaimaa.billing.domain.Billing;
import io.hdidouchaimaa.billing.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billings")
@RequiredArgsConstructor
public class BillingResource {

    private final BillingRepository billingRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @GetMapping("/fullBill/{id}")
    public Billing bill(@PathVariable Long id){
        Billing bill= this.billingRepository.findById(id).get();
        bill.setCustomer(this.customerClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(this.productClient.findProductById(pi.getProductId()));
        });
        return bill;
    }
}
