package org.perscholas.onlineshoppingapp.security;

import org.perscholas.onlineshoppingapp.dao.AuthGroupRepository;
import org.perscholas.onlineshoppingapp.dao.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MyUserDetailsService implements UserDetailsService {


    MyUserRepository myUserRepository;
    AuthGroupRepository authGroupRepository;

    public MyUserDetailsService(MyUserRepository myUserRepository, AuthGroupRepository authGroupRepository) {
        this.myUserRepository = myUserRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserPrincipal
                (myUserRepository.findByEmailAllIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("Did not find the email" + username))
                        , authGroupRepository.findByEmail(username));
    }
}
