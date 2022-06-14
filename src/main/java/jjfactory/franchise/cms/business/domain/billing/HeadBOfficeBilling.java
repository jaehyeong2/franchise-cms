package jjfactory.franchise.cms.business.domain.billing;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class HeadBOfficeBilling extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Comment("충전 내역")
    @ManyToOne(fetch = FetchType.LAZY)
    private Payments payments;

    @Comment("최종 정산 금액")
    private long amount;

    @Comment("영업자에게 지급한 금액")
    private long salesPaymentAmount;

    @Comment("Van사에 지급한 금액")
    private long vanPaymentAmount;

    @Comment("PG사 정산 금액")
    private long pgPaymentAmount;

    @Comment("PG사 수수료 %")
    private Double pgFeeLate;

    @Comment("정산완료 여부")
    @Enumerated(EnumType.STRING)
    private BillingStatus status;

    @Comment("정산 예정일")
    private LocalDateTime expectedDate;

    @Builder
    public HeadBOfficeBilling(Payments payments, long amount, long salesPaymentAmount, long vanPaymentAmount, long pgPaymentAmount, Double pgFeeLate, LocalDateTime expectedDate) {
        this.payments = payments;
        this.amount = amount;
        this.salesPaymentAmount = salesPaymentAmount;
        this.vanPaymentAmount = vanPaymentAmount;
        this.pgPaymentAmount = pgPaymentAmount;
        this.pgFeeLate = pgFeeLate;
        this.expectedDate = expectedDate;
    }
}
