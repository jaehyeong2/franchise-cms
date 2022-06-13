package jjfactory.franchise.cms.business.repository.billing;

import jjfactory.franchise.cms.business.domain.billing.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments,Long> {
}
