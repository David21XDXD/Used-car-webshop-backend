package com.davidproject.usedcar.service.interfaces;

import com.davidproject.usedcar.model.UsedCarUser;
import org.springframework.security.oauth2.jwt.Jwt;

public interface IUserService {
    UsedCarUser getOrCreateUser(Jwt jwt);
}
