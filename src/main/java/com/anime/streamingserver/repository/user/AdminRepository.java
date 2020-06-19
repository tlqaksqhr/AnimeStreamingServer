package com.anime.streamingserver.repository.user;

import com.anime.streamingserver.entity.user.Admin;
import com.anime.streamingserver.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmail(String email);
    Boolean existsByEmail(String email);
}
