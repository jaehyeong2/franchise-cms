package jjfactory.franchise.cms.business.domain.branch;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.admin.Admin;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Branch extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;

    @Comment("등록 관리자 아이디")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin createAdmin;

    @Comment("수정 관리자 아이디")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin modifyAdmin;

    @Comment("상위 지점 아이디")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch upperBranch;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "upperBranch")
    private final List<Branch> childBranch = new ArrayList<>();

    @Comment("지점코드")
    private String branchCode;

    @Comment("지점 노드 (Depth)")
    private Integer branchLevel;

    @Comment("지점명")
    private String branchName;

    @Comment("사업자등록번호")
    private String branchBizNum;

    @Comment("업무형태")
    private String branchBizType;

    @Comment("업종")
    private String branchBizItem;

    @Comment("우편번호")
    private String branchPost;

    @Comment("사업자 주소지1")
    private String branchAddr1;

    @Comment("사업자 주소지2")
    private String branchAddr2;

    @Comment("은행명")
    private String branchBank;

    @Comment("예금주")
    private String branchAccName;

    @Comment("계좌번호")
    private String branchAccNo;

    @Comment("수수료 %")
    private Double branchRate;

    @Comment("지점 전화번호")
    private String branchPhone;

    @Comment("지점 이메일")
    private String branchEmail;

    @Comment("사용여부(Y:사용함,N:사용안함)")
    private String useYN;

    @Builder
    public Branch(Admin createAdmin, Admin modifyAdmin, Branch upperBranch, String branchCode, Integer branchLevel, String branchName, String branchBizNum, String branchBizType, String branchBizItem, String branchPost, String branchAddr1, String branchAddr2, String branchBank, String branchAccName, String branchAccNo, Double branchRate, String branchPhone, String branchEmail, String useYN) {
        this.createAdmin = createAdmin;
        this.modifyAdmin = modifyAdmin;
        this.upperBranch = upperBranch;
        this.branchCode = branchCode;
        this.branchLevel = branchLevel;
        this.branchName = branchName;
        this.branchBizNum = branchBizNum;
        this.branchBizType = branchBizType;
        this.branchBizItem = branchBizItem;
        this.branchPost = branchPost;
        this.branchAddr1 = branchAddr1;
        this.branchAddr2 = branchAddr2;
        this.branchBank = branchBank;
        this.branchAccName = branchAccName;
        this.branchAccNo = branchAccNo;
        this.branchRate = branchRate;
        this.branchPhone = branchPhone;
        this.branchEmail = branchEmail;
        this.useYN = useYN;
    }
}
