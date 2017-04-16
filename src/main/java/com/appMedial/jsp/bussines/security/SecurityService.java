package com.appMedial.jsp.bussines.security;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appMedial.jsp.bussines.UserService;
import com.appMedial.jsp.model.User;


@Service("securityService")
public class SecurityService implements UserDetailsService{
	private static final Log log = LogFactory.getLog(SecurityConfig.class);

    @Autowired
    private UserService userService;

    @Autowired
    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with this email: " + username);
        }else {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(user.getProfile()))));
        }
    }
}
