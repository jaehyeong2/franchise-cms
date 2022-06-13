package jjfactory.franchise.cms.business.repository.notice;

import jjfactory.franchise.cms.business.domain.notice.Notice;
import jjfactory.franchise.cms.business.domain.notice.NoticeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeImageRepository extends JpaRepository<NoticeImage,Long> {
}
