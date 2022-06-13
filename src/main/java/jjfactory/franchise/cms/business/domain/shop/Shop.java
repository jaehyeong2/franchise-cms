package jjfactory.franchise.cms.business.domain.shop;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.sales.SalesMan;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Shop extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SalesMan salesMan;

    private String username;

    private String password;

    private String shopName;

    private String bossName;

    private String businessNumber;

    private String businessNumberImage;

    private String phone;

    private String email;

    private String recommenderCode;

    private long point;

    private long totalPayAmount;

    private Boolean usedYn;

    @Builder
    public Shop(SalesMan salesMan, String username, String password, String shopName, String bossName, String businessNumber, String businessNumberImage, String phone, String email, String recommenderCode, long point, long totalPayAmount, Boolean usedYn) {
        this.salesMan = salesMan;
        this.username = username;
        this.password = password;
        this.shopName = shopName;
        this.bossName = bossName;
        this.businessNumber = businessNumber;
        this.businessNumberImage = businessNumberImage;
        this.phone = phone;
        this.email = email;
        this.recommenderCode = recommenderCode;
        this.point = point;
        this.totalPayAmount = totalPayAmount;
        this.usedYn = usedYn;
    }
}
