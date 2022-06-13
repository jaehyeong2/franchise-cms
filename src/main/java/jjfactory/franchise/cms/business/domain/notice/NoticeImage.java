package jjfactory.franchise.cms.business.domain.notice;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class NoticeImage extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;

    @Comment("이미지 경로")
    private String path;

    @Comment("활성화 여부")
    private Boolean isView;

    @Builder
    public NoticeImage(Notice notice, String path, Boolean isView) {
        this.notice = notice;
        this.path = path;
        this.isView = isView;
    }

    public static NoticeImage create(Notice notice, String path){
        return NoticeImage.
                builder()
                .notice(notice)
                .path(path)
                .isView(true)
                .build();
    }
}
