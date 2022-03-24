package studio.fabrique.polls.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import studio.fabrique.polls.domain.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface UserService extends UserDetailsService {
    default List<SimpleGrantedAuthority> mapToSimpleGrantedAuthority(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
