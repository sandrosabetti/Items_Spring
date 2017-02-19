package main.model.service.user;


import main.model.entity.Role;
import main.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.getUser(name);
//        Set<GrantedAuthority> roles = new HashSet<>();

/*        for (Role role :
                user.getRoles()) {
            roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }*/

        Set<GrantedAuthority> roles = user.getRoles().stream()
                .map(Role::getRole)
                .map(e -> "ROLE_" + e)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }

}