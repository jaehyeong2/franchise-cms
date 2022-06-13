package jjfactory.franchise.cms.business.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdminCreateDto {
    private String username;
    private String name;
    private String password;
    private String phone;
    private String email;
    private Long groupId;
    private Long branchId;
}
