package jjfactory.franchise.cms.business.repository.notice;

import jjfactory.franchise.cms.business.domain.admin.Admin;
import jjfactory.franchise.cms.business.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
