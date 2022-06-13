package jjfactory.franchise.cms.business.repository.shop;

import jjfactory.franchise.cms.business.domain.notice.Notice;
import jjfactory.franchise.cms.business.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
