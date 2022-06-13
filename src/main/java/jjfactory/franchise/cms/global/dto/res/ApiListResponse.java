package jjfactory.franchise.cms.global.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor()
@AllArgsConstructor
@Setter
public class ApiListResponse<T> {
    private List<T> body;

}
