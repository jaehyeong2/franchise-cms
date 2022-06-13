package jjfactory.franchise.cms.business.repository.branch;

import jjfactory.franchise.cms.business.domain.admin.Admin;
import jjfactory.franchise.cms.business.domain.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
