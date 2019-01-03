package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.entities.User;
import fr.formation.twitterxs.jparepository.UserJpaRepository;
import fr.formation.twitterxs.security.Principal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserJpaRepository jpaUser;

    public UserDetailsServiceImpl(UserJpaRepository jpaUser) {
        this.jpaUser = jpaUser;
    }

    // Principal is a UserDetails => covariant return
    @Override
    public Principal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jpaUser.findBySecurityUsername(username);
        if(null == user){
            throw new UsernameNotFoundException("No user found with username:" + username);
        }
        return new Principal(user);
    }
}
