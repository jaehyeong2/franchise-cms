package jjfactory.franchise.cms.business.repository.shop;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.franchise.cms.business.dto.shop.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static jjfactory.franchise.cms.business.domain.shop.QShop.shop;

@RequiredArgsConstructor
@Repository
public class ShopQueryRepository {
    private final JPAQueryFactory queryFactory;

    public ShopResponse findByRecommenderCode(String code){
        return queryFactory.select(Projections.constructor(ShopResponse.class,shop))
                .from(shop)
                .fetchOne();
    }

    public BooleanExpression isSalesManId(List<Long> salesId){
        if(salesId == null) return null;
        if(salesId.size() == 0) return shop.id.isNull();

        return shop.salesMan.id.in(salesId);
    }

    public long countTotal(List<Long> salesManId){
        return queryFactory.selectFrom(shop)
                .where(shop.id.isNotNull(),isSalesManId(salesManId))
                .fetch().size();
    }

    public long countToday(List<Long> salesManId){
        return queryFactory.selectFrom(shop)
                .where(shop.id.isNotNull(),isSalesManId(salesManId),
                        shop.createdDate.between(LocalDateTime.of(LocalDate.now(), LocalTime.MIN), LocalDateTime.of(LocalDate.now(),LocalTime.MAX)))
                .fetch().size();
    }
}
