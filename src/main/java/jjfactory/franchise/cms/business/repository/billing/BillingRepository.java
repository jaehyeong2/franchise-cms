package jjfactory.franchise.cms.business.repository.billing;

import jjfactory.franchise.cms.business.domain.billing.SalesBilling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<SalesBilling,Long> {
}
