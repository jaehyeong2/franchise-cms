package jjfactory.franchise.cms.business.api.notice;

import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.dto.notice.NoticeDto;
import jjfactory.franchise.cms.business.dto.notice.NoticeResponse;
import jjfactory.franchise.cms.business.service.notice.NoticeService;
import jjfactory.franchise.cms.global.config.auth.PrincipalDetails;
import jjfactory.franchise.cms.global.dto.req.MyPageRequest;
import jjfactory.franchise.cms.global.dto.res.ApiPagingResponse;
import jjfactory.franchise.cms.global.dto.res.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@RequestMapping("/notices")
@RequiredArgsConstructor
@RestController
public class NoticeApi {
    private final NoticeService noticeService;

    @GetMapping("")
    public ApiPagingResponse<NoticeResponse> findNotices(@RequestParam(defaultValue = "1", required = false) int page,
                                                         @RequestParam(defaultValue = "!0", required = false) int limit,
                                                         @RequestParam(required = false) String query,
                                                         @RequestParam(required = false) String startDate,
                                                         @RequestParam(required = false) String endDate){
        return new ApiPagingResponse<>(noticeService.findNotices(new MyPageRequest(page,limit).of(),query,startDate,endDate));
    }

    @GetMapping("{id}")
    public ApiResponse<NoticeResponse> findNoticeById(@PathVariable Long id){
        return new ApiResponse<>(noticeService.findNoticeById(id));
    }

    @PostMapping("")
    public ApiResponse<String> createNotice(@RequestPart(required = false) NoticeDto dto,
                                            @RequestPart(required = false) List<MultipartFile> images,
                                            @AuthenticationPrincipal PrincipalDetails principal){
        return new ApiResponse<>(noticeService.create(dto,images,principal.getUser()));
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> deleteNotice(@PathVariable Long id){
        return new ApiResponse<>(noticeService.delete(id));
    }
}
