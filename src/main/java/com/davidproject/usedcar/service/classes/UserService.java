package com.davidproject.usedcar.service.classes;

import com.davidproject.usedcar.model.UsedCarUser;
import com.davidproject.usedcar.repository.UserRepository;
import com.davidproject.usedcar.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UsedCarUser getOrCreateUser(Jwt jwt) {
        String auth0Id = jwt.getSubject();
        return userRepository.findByAuth0Id(auth0Id)
                .orElseGet(() -> {
                    UsedCarUser newUser = new UsedCarUser();
                    newUser.setAuth0Id(auth0Id);
                    newUser.setEmail(jwt.getClaimAsString("email"));
                    return userRepository.save(newUser);
                });
    }
}
