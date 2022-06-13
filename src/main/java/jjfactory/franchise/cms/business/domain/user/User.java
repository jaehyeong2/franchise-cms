package jjfactory.franchise.cms.business.domain.user;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    private String useYN;

    private LocalDateTime lastLoginDate;

    private List<Role> roles = new ArrayList<>();

    public void delete(){
        this.useYN = "N";
    }
}
