package jjfactory.franchise.cms.business.domain.billing;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.shop.Shop;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Payments extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private String userId;

    private long chargePoint;
    private long payAmount;
    private long totalPayAmount;

    private String cardNumber;
    private String TID;
    private String state;
    private String resultMessage;
    private String resultCode;
    private String payType;
    private String orderNumber;

    private LocalDateTime payDate;

}
