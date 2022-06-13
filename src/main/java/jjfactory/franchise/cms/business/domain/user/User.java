package jjfactory.franchise.cms.business.domain.user;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
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

    @ElementCollection(fetch = FetchType.LAZY) //이거 없으면 에러남
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    @Builder
    public User(String username, String password, String useYN, LocalDateTime lastLoginDate, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.useYN = useYN;
        this.lastLoginDate = lastLoginDate;
        this.roles = roles;
    }


    public void delete(){
        this.useYN = "N";
    }
}
