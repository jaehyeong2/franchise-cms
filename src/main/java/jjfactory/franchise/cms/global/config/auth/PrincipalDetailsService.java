package jjfactory.franchise.cms.global.config.auth;


import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.repository.user.UserRepository;
import jjfactory.franchise.cms.global.error.exception.BusinessException;
import jjfactory.franchise.cms.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null) throw new BusinessException(ErrorCode.NOT_FOUND_USER);
        return new PrincipalDetails(user);
    }
}
