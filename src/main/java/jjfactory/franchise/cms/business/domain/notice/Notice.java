package jjfactory.franchise.cms.business.domain.notice;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import jjfactory.franchise.cms.business.domain.admin.Admin;
import jjfactory.franchise.cms.business.dto.notice.NoticeDto;
import jjfactory.franchise.cms.business.dto.notice.NoticeUpdateReq;
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

    @Comment("활성화 여무")
    private Boolean isView;

    @Builder
    public Notice(Admin createAdmin, Admin modifyAdmin, String title, String type, String content, Boolean isView) {
        this.createAdmin = createAdmin;
        this.modifyAdmin = modifyAdmin;
        this.title = title;
        this.type = type;
        this.content = content;
        this.isView = isView;
    }

    public static Notice create(NoticeDto dto,Admin admin){
        return builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .createAdmin(admin)
                .isView(true)
                .type("1")
                .build();
    }

    public void deleteView() {
        this.isView = false;
    }

    public void updateNotice(NoticeUpdateReq dto, Admin admin){
        this.content = dto.getContent();
        this.title = dto.getTitle();
        this.type = dto.getType();
    }

    public void addImage(NoticeImage image){
        this.imageList.add(image);
    }

}
