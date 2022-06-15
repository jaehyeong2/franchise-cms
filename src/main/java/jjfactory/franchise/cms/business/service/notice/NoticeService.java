package jjfactory.franchise.cms.business.service.notice;

import jjfactory.franchise.cms.business.domain.admin.Admin;
import jjfactory.franchise.cms.business.domain.notice.Notice;
import jjfactory.franchise.cms.business.domain.notice.NoticeImage;
import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.dto.notice.NoticeDto;
import jjfactory.franchise.cms.business.dto.notice.NoticeResponse;
import jjfactory.franchise.cms.business.dto.notice.NoticeUpdateReq;
import jjfactory.franchise.cms.business.repository.admin.AdminRepository;
import jjfactory.franchise.cms.business.repository.notice.NoticeImageRepository;
import jjfactory.franchise.cms.business.repository.notice.NoticeQueryRepository;
import jjfactory.franchise.cms.business.repository.notice.NoticeRepository;
import jjfactory.franchise.cms.global.dto.QueryModel;
import jjfactory.franchise.cms.global.dto.res.PagingResponse;
import jjfactory.franchise.cms.global.error.exception.BusinessException;
import jjfactory.franchise.cms.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;
    private final NoticeImageRepository noticeImageRepository;
    private final AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public PagingResponse<NoticeResponse> findNotices(Pageable pageable,
                                                      String query,
                                                      String startDate, String endDate){
        return new PagingResponse<>(noticeQueryRepository.findNotices(pageable,new QueryModel(query,startDate,endDate)));
    }

    @Transactional(readOnly = true)
    public NoticeResponse findNoticeById(Long id){
        Notice notice = getNotice(id);
        return new NoticeResponse(notice);
    }

    public String create(NoticeDto dto, List<MultipartFile> images, User user){
        Admin admin = getAdmin(user);
        Notice notice = Notice.create(dto, admin);
        noticeRepository.save(notice);

        List<NoticeImage> noticeImages = new ArrayList<>();
        if(images != null){
            images.forEach(image -> {
                String folderPath = "/images/notice" + notice.getId() + "/";

                String filePath = folderPath + image.getOriginalFilename();
                NoticeImage noticeImage = NoticeImage.create(notice, filePath);
                noticeImages.add(noticeImage);
                notice.addImage(noticeImage);
            });

        }

        return "Y";
    }

    public String update(Long id, NoticeUpdateReq dto, User user){
        Notice notice = getNotice(id);
        Admin admin = getAdmin(user);
        notice.updateNotice(dto,admin);
        return "Y";
    }

    private Admin getAdmin(User user) {
        Admin admin = adminRepository.findById(user.getId()).orElseThrow(() -> {
            throw new BusinessException(ErrorCode.ENTITY_NOT_FOUND);
        });
        return admin;
    }

    public String delete(Long id){
        Notice notice = getNotice(id);
        notice.deleteView();
        return "Y";
    }

    private Notice getNotice(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> {
            throw new BusinessException(ErrorCode.ENTITY_NOT_FOUND);
        });
        return notice;
    }
}