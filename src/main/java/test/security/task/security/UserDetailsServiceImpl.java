package test.security.task.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.security.task.entities.UserEntity;
import test.security.task.repos.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User with this email doesn't exist"));

        return UserDetailsImpl.build(userEntity);
    }
}
