package jjfactory.franchise.cms.business.service.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminService {
    public String create(){
        return "Y";
    }

    public String update(Long id){
        return "Y";
    }

    public String delete(Long id){
        return "Y";
    }
}
