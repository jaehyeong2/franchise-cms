package jjfactory.franchise.cms.business.domain.admin;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.branch.Branch;
import jjfactory.franchise.cms.business.domain.user.Role;
import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.dto.admin.AdminCreateDto;
import jjfactory.franchise.cms.business.dto.admin.AdminUpdateDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Admin extends User {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private AdminCode code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;

    private String name;
    private String phone;
    private String email;

    @Comment("등록자 아이디")
    private String createAdmin;
    @Comment("수정한 관리자 아이디")
    private String modifyAdmin;


    @Builder
    public Admin(Long id, String username, String password, String useYN, LocalDateTime lastLoginDate, List<Role> roles, Long id1, AdminCode code, Branch branch, String name, String phone, String email, String createAdmin, String modifyAdmin) {
        super(username, password, useYN, lastLoginDate, roles);
        this.id = id1;
        this.code = code;
        this.branch = branch;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createAdmin = createAdmin;
        this.modifyAdmin = modifyAdmin;
    }

    public static Admin createSuperAdmin(AdminCreateDto dto, String password){
        return Admin.builder()
                .email(dto.getEmail())
                .code(AdminCode.HEAD_OFFICE)
                .username(dto.getUsername())
                .password(password)
                .name(dto.getName())
                .phone(dto.getPhone())
                .useYN("1")
                .roles(Collections.singletonList(Role.ROLE_SUPER_ADMIN))
                .build();
    }

    public static Admin createBranchAdmin(AdminCreateDto dto, String password){
        return Admin.builder()
                .email(dto.getEmail())
                .code(AdminCode.HEAD_OFFICE)
                .username(dto.getUsername())
                .password(password)
                .name(dto.getName())
                .phone(dto.getPhone())
                .useYN("1")
                .roles(Collections.singletonList(Role.ROLE_ADMIN))
                .build();
    }

    public void updateBranch(Branch branch){
        this.branch = branch;
    }

    public void updateTotal(AdminUpdateDto dto, AdminCode code){
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.phone = dto.getPhone();
        this.code = code;
    }
}
