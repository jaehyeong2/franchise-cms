package jjfactory.franchise.cms.business.service.shop;

import jjfactory.franchise.cms.business.repository.shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ShopService {
    private final ShopRepository shopRepository;

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