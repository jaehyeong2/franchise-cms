package jjfactory.franchise.cms.business.repository.user;

import jjfactory.franchise.cms.business.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
