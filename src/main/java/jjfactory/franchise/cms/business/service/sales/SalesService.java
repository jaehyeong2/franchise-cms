package jjfactory.franchise.cms.business.service.sales;

import jjfactory.franchise.cms.business.domain.branch.Branch;
import jjfactory.franchise.cms.business.domain.sales.SalesMan;
import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.dto.sales.SalesManDto;
import jjfactory.franchise.cms.business.dto.sales.SalesResponse;
import jjfactory.franchise.cms.business.repository.branch.BranchRepository;
import jjfactory.franchise.cms.business.repository.sales.SalesQueryRepository;
import jjfactory.franchise.cms.business.repository.sales.SalesRepository;
import jjfactory.franchise.cms.global.error.exception.BusinessException;
import jjfactory.franchise.cms.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class SalesService {
    private final SalesQueryRepository salesQueryRepository;
    private final SalesRepository salesRepository;
    private final BranchRepository branchRepository;

    @Transactional(readOnly = true)
    public SalesResponse findSalesMan(Long id){
        SalesMan salesMan = getSalesMan(id);

        return new SalesResponse(salesMan);
    }

    @Transactional(readOnly = true)
    public Page<SalesResponse> findSalesList(Pageable pageable){
        return salesQueryRepository.findSales(pageable);
    }

    public String create(SalesManDto dto, User user){
        Branch branch = branchRepository.findById(dto.getBranchId()).orElseThrow(() -> {
            return new BusinessException(ErrorCode.ENTITY_NOT_FOUND);
        });
        SalesMan salesMan = SalesMan.enroll(dto, branch, user.getUsername());
        salesRepository.save(salesMan);
        return "Y";
    }

    public String update(Long id){
        return "Y";
    }

    public String delete(Long id){
        SalesMan salesMan = getSalesMan(id);
        salesMan.delete();
        return "Y";
    }

    private SalesMan getSalesMan(Long id) {
        SalesMan salesMan = salesRepository.findById(id).orElseThrow(() -> {
            throw new BusinessException(ErrorCode.ENTITY_NOT_FOUND);
        });
        return salesMan;
    }
}