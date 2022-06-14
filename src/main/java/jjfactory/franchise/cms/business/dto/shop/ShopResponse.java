package jjfactory.franchise.cms.business.dto.shop;

import jjfactory.franchise.cms.business.domain.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShopResponse {
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

    public ShopResponse(Shop shop) {
        this.shopName = shop.getShopName();
        this.bossName = shop.getBossName();
        this.businessNumber = shop.getBusinessNumber();
        this.businessNumberImage = shop.getBusinessNumberImage();
        this.phone = shop.getPhone();
        this.email = shop.getEmail();
        this.recommenderCode = shop.getRecommenderCode();
        this.point = shop.getPoint();
        this.totalPayAmount = shop.getTotalPayAmount();
        this.usedYn = shop.getUsedYn();
    }
}
