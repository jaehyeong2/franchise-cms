package jjfactory.franchise.cms.business.service.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {
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