package com.chathura.lapmart.auth_server.repo;

import com.chathura.lapmart.auth_server.entity.Role;
import com.chathura.lapmart.auth_server.enums.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(AppRole name);
}
