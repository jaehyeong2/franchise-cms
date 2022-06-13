package jjfactory.franchise.cms.business.domain.notice;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.admin.Admin;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Notice extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "notice")
    private final List<NoticeImage> imageList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("생성한 관리자")
    private Admin createAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin modifyAdmin;

    @Comment("제목")
    private String title;

    @Comment("공지사항 타입")
    private String type;

    @Comment("내용")
    private String content;

    @Comment("활성화 여무 1:활성화 2:비활성화(삭제)")
    private String isView;

    @Builder
    public Notice(Admin createAdmin, Admin modifyAdmin, String title, String type, String content, String isView) {
        this.createAdmin = createAdmin;
        this.modifyAdmin = modifyAdmin;
        this.title = title;
        this.type = type;
        this.content = content;
        this.isView = isView;
    }
}
