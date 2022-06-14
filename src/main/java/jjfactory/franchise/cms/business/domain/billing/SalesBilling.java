package jjfactory.franchise.cms.business.domain.billing;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.branch.Branch;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SalesBilling extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Payments payments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;

    @Comment("정산 금액")
    private long amount;

    @Comment("수수료 %")
    private Double feeLate;

    @Comment("정산완료 여부")
    @Enumerated(EnumType.STRING)
    private BillingStatus status;

    @Comment("정산예정일")
    private LocalDateTime expectedDate;

    public SalesBilling(Payments payments, Branch branch, long amount, Double feeLate,LocalDateTime expectedDate) {
        this.payments = payments;
        this.branch = branch;
        this.amount = amount;
        this.feeLate = feeLate;
        this.status = BillingStatus.READY;
        this.expectedDate = expectedDate;
    }
}
