package com.thecar.securitytest.security.service;

import com.thecar.securitytest.repository.UserRepository;
import com.thecar.securitytest.security.UserInfo;
import com.thecar.securitytest.security.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserSecurityService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private MessageSource messageSource;

    public UserInfo loadUserByUsername(String username){

        System.err.println("@@@성공기원 service");

        UserInfo user = userRepository.findByUsername(username);

        if(user == null) {
            throw new BadCredentialsException("존재하지 않는 사용자입니다.");
            //throw new BadCredentialsException(messageSource.getMessage("fail.common.pwd.different", null,Locale.getDefault()));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));


     /*   System.err.println("@@@이름 : " + user.getName());
        System.err.println("@@@비밀번호 : " + user.getPassword());
        System.err.println("@@@성별 : " + user.getGender());
        System.err.println("@@@이메일 : " + user.getEmail());
        System.err.println("@@@나이 : " + user.getAge());
        System.err.println("@@@전화번호 : " + user.getPhoneNumber());*/

        return user;
    }
}
