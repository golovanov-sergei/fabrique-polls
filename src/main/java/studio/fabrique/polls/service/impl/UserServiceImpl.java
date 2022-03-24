package studio.fabrique.polls.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.User;
import studio.fabrique.polls.repositories.UserRepository;
import studio.fabrique.polls.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_NOT_FOUND = "User (%s) not found.";
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapToSimpleGrantedAuthority(
                        user.getRoles()));
    }
}
