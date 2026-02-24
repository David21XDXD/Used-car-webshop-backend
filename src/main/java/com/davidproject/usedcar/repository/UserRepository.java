package com.davidproject.usedcar.repository;

import com.davidproject.usedcar.model.UsedCarUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsedCarUser, Long> {
    Optional<UsedCarUser> findByAuth0Id(String auth0Id);
}
