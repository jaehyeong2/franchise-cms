package jjfactory.franchise.cms.business.domain.sales;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.branch.Branch;
import jjfactory.franchise.cms.business.domain.user.Role;
import jjfactory.franchise.cms.business.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SalesMan extends User {
    @Id
    @GeneratedValue
    private Long id;

    @Comment("영업자 코드")
    private String salesCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;

    @Comment("영업자 이름")
    private String salesName;

    @Comment("영업자 주민등록번호")
    private String salesSsn;

    @Comment("영업자 전화번호")
    private String salesPhone;

    @Comment("영업자 이메일")
    private String salesEmail;

    @Comment("은행명")
    private String salesBankName;

    @Comment("예금주")
    private String salesAccountName;

    @Comment("계좌번호")
    private String salesAccountNum;

    @Comment("수수료 %")
    private Double salesRate;

    @Comment("생성한 관리자")
    private String createAdmin;

    @Comment("수정한 관리자")
    private String modifyAdmin;

    @Builder(builderMethodName = "salesManBuilder")
    public SalesMan(String username, String password, String useYN, LocalDateTime lastLoginDate, List<Role> roles, String salesCode, Branch branch, String salesName, String salesSsn, String salesPhone, String salesEmail, String salesBankName, String salesAccountName, String salesAccountNum, Double salesRate, String createAdmin, String modifyAdmin) {
        super(username, password, useYN, lastLoginDate, roles);
        this.salesCode = salesCode;
        this.branch = branch;
        this.salesName = salesName;
        this.salesSsn = salesSsn;
        this.salesPhone = salesPhone;
        this.salesEmail = salesEmail;
        this.salesBankName = salesBankName;
        this.salesAccountName = salesAccountName;
        this.salesAccountNum = salesAccountNum;
        this.salesRate = salesRate;
        this.createAdmin = createAdmin;
        this.modifyAdmin = modifyAdmin;
    }
}
