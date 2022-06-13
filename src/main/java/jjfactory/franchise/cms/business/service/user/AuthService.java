package jjfactory.franchise.cms.business.service.user;

import jjfactory.franchise.cms.business.domain.user.User;
import jjfactory.franchise.cms.business.dto.user.LoginDto;
import jjfactory.franchise.cms.business.dto.user.TokenResponse;
import jjfactory.franchise.cms.business.repository.user.UserRepository;
import jjfactory.franchise.cms.global.error.exception.BusinessException;
import jjfactory.franchise.cms.global.error.model.ErrorCode;
import jjfactory.franchise.cms.global.provider.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public TokenResponse login(LoginDto dto) throws NoSuchAlgorithmException {
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(() -> {
            throw new BusinessException(ErrorCode.NOT_FOUND_USER);
        });
//        user.updateLastLoginDate();
        matchPassword(dto.getPassword(), user.getPassword());
        String token = createToken(user);
        return new TokenResponse(token);
    }

    public String createToken(User user){
        return tokenProvider.createToken(String.valueOf(user.getId()),user.getRoles());
    }
    public void matchPassword(String reqPassword,String userPassword){

        boolean result =reqPassword.equals(userPassword);

        if(!result){
            throw new BusinessException(ErrorCode.NOT_MATCH_PASSWORD);
        }
    }

    public String duplicateId(String id){
        if(userRepository.findByUsername(id).isPresent()){
            throw  new BusinessException(ErrorCode.DUPLICATE_LOGIN_ID);
        };
        return "Y";
    }
}
