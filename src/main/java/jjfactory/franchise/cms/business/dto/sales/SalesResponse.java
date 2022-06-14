package jjfactory.franchise.cms.business.dto.sales;

import jjfactory.franchise.cms.business.domain.sales.SalesMan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SalesResponse {
    private Long id;
    private String branchName;
    private String salesName;
    private String salesPhone;
    private String salesBank;
    private Double salesRate;
    private String salesEmail;
    private String lastLoginDate;
    private String createdDate;
    private String salesSocNo;
    private String salesCode;
    private String salesAccName;
    private String salesAccNo;
    private String username;
    private String useYN;

    public SalesResponse(SalesMan salesMan){
        this.id =salesMan.getId();
        this.useYN = salesMan.getUseYN();
        this.username = salesMan.getUsername();
        this.branchName = salesMan.getBranch().getBranchName();
        this.salesPhone = salesMan.getSalesPhone();
        this.salesBank  =salesMan.getSalesBankName();
        this.salesRate = salesMan.getSalesRate();
        this.salesEmail = salesMan.getSalesEmail();
        this.lastLoginDate = String.valueOf(salesMan.getLastLoginDate());
        this.createdDate  = String.valueOf(salesMan.getCreatedDate());
        this.salesName = salesMan.getSalesName();
//        this.salesSocNo = salesMan.getSalesSocNo();
        this.salesCode = salesMan.getSalesCode();
        this.salesAccName = salesMan.getSalesAccountName();
        this.salesAccNo = salesMan.getSalesAccountNum();
    }
}
