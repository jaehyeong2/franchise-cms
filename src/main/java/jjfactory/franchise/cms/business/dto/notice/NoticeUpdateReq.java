package jjfactory.franchise.cms.business.dto.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeUpdateReq {
    private String title;
    private String content;
    private String type;
}
