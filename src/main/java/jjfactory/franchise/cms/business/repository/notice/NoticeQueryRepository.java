package jjfactory.franchise.cms.business.repository.notice;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.franchise.cms.business.dto.notice.NoticeResponse;
import jjfactory.franchise.cms.global.dto.QueryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static jjfactory.franchise.cms.business.domain.notice.QNotice.notice;

@RequiredArgsConstructor
@Repository
public class NoticeQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<NoticeResponse> findNotices(Pageable pageable, QueryModel queryModel) {
        List<NoticeResponse> result = queryFactory.select(Projections.constructor(NoticeResponse.class, notice))
                .from(notice)
                .where(notice.id.isNotNull(), query(queryModel.getQuery()), betweenDate(queryModel))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(notice.createdDate.desc())
                .fetch();

        int totalCount = queryFactory.select(Projections.constructor(NoticeResponse.class, notice))
                .from(notice)
                .where(notice.id.isNotNull(),query(queryModel.getQuery()),betweenDate(queryModel))
                .fetch().size();

        return new PageImpl<>(result, pageable, totalCount);
    }


    private BooleanExpression query(String query) {
        if (query == null) return null;
        return notice.content.contains(query)
                .or(notice.title.contains(query))
                .or(notice.createAdmin.name.contains(query));
    }

    private BooleanExpression betweenDate(QueryModel queryModel) {
        LocalDateTime startDate = queryModel.getStartDate();
        LocalDateTime endDate = queryModel.getEndDate();

        if (startDate == null || endDate == null) return null;
        return notice.createdDate.between(startDate, endDate);
    }
}
