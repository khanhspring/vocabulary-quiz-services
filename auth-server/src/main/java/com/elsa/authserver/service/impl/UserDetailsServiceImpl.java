package com.elsa.authserver.service.impl;

import com.elsa.authserver.infrastructure.common.enumeration.UserStatus;
import com.elsa.authserver.infrastructure.entity.JpaUser;
import com.elsa.authserver.infrastructure.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final JpaUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameAndStatus(username, UserStatus.Active)
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        return toUserDetails(user);
    }

    private UserDetails toUserDetails(JpaUser user) {
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getStatus() == UserStatus.Active,
                true,
                true,
                user.getStatus() != UserStatus.Locked,
                AuthorityUtils.NO_AUTHORITIES
        );
    }
}
