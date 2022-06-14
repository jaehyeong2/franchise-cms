package jjfactory.franchise.cms.business.dto.notice;

import jjfactory.franchise.cms.business.domain.notice.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeResponse {
    private String title;
    private String content;

    public NoticeResponse(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}
