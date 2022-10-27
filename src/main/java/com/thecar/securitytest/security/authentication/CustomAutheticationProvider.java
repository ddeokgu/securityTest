
package com.thecar.securitytest.security.authentication;

import com.thecar.securitytest.security.UserInfo;
import com.thecar.securitytest.security.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class CustomAutheticationProvider implements AuthenticationProvider {

    @Autowired
    private UserSecurityService userMemberService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MessageSource messageSource;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.err.println("@@@성공기원 authenticate");
        String password = authentication.getCredentials().toString();
        String username = authentication.getName();

        UserInfo user = null;

        user = userMemberService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
        System.err.println(username);

        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }



    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

