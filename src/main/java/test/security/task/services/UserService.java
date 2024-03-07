package test.security.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.security.task.entities.UserEntity;
import test.security.task.repos.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;

    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userRepo.save(userEntity);

    }
}
