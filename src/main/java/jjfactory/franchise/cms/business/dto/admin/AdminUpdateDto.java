package jjfactory.franchise.cms.business.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdminUpdateDto {
    private String email;
    private String name;
    private String phone;
}
