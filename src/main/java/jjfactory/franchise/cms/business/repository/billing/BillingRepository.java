package jjfactory.franchise.cms.business.repository.billing;

import jjfactory.franchise.cms.business.domain.admin.Admin;
import jjfactory.franchise.cms.business.domain.billing.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing,Long> {
}
