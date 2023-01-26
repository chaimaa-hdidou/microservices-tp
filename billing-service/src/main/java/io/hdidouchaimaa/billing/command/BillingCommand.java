package io.hdidouchaimaa.billing.command;

import lombok.Data;

@Data
public class BillingCommand {

    private Long productId;
    private Long customerId;
}
