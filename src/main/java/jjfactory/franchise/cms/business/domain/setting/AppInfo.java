package jjfactory.franchise.cms.business.domain.setting;

import jjfactory.franchise.cms.business.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AppInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;
}
