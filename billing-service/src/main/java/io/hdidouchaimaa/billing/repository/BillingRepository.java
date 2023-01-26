package io.hdidouchaimaa.billing.repository;

import io.hdidouchaimaa.billing.domain.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}
