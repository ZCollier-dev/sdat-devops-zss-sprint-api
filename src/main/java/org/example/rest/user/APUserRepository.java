package org.example.rest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APUserRepository extends JpaRepository<APUser, Long> {
    APUser findByEmail(String email);
}
