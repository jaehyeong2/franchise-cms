package jjfactory.franchise.cms.business.repository.sales;

import jjfactory.franchise.cms.business.domain.sales.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {
}
