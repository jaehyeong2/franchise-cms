package jjfactory.franchise.cms.business.repository.sales;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.franchise.cms.business.dto.sales.SalesResponse;
import jjfactory.franchise.cms.global.dto.QueryModel;
import jjfactory.franchise.cms.global.error.exception.BusinessException;
import jjfactory.franchise.cms.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static jjfactory.franchise.cms.business.domain.sales.QSalesMan.salesMan;

@RequiredArgsConstructor
@Repository
public class SalesQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<SalesResponse> findSales(Pageable pageable){
        List<SalesResponse> result = queryFactory.select(Projections.constructor(SalesResponse.class, salesMan))
                .from(salesMan)
                .orderBy(salesMan.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int totalCount = queryFactory.select(Projections.constructor(SalesResponse.class, salesMan))
                .from(salesMan)
                .fetch().size();

        return new PageImpl<>(result,pageable,totalCount);
    }

    public void codeDuplicateCheck(String code){
        int count = queryFactory.selectFrom(salesMan)
                .where(salesMan.salesCode.eq(code))
                .fetch().size();
        if (count != 0) throw new BusinessException(ErrorCode.DUPLICATE_SALES_CODE);
    }


    private BooleanExpression query(String query){
        if(query == null) return null;
        return salesMan.salesName.contains(query);
    }

    private BooleanExpression betweenDate(QueryModel queryModel){
        LocalDateTime startDate = queryModel.getStartDate();
        LocalDateTime endDate = queryModel.getEndDate();
        if(startDate == null || endDate == null) return null;
        return salesMan.createdDate.between(startDate,endDate);
    }

    public long countTotal(){
        return 1L;
    }

    public long countToday(){
        return 1L;
    }

}
