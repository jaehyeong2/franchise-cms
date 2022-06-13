package jjfactory.franchise.cms.business.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDto {
    private String username;
    private String password;
}
