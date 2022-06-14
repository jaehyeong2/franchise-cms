package jjfactory.franchise.cms.business.dto.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShopDto {
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
}
