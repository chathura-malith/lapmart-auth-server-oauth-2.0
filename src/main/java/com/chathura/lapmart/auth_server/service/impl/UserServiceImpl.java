package com.chathura.lapmart.auth_server.service.impl;

import com.chathura.lapmart.auth_server.dto.request.RequestUserDto;
import com.chathura.lapmart.auth_server.entity.Role;
import com.chathura.lapmart.auth_server.entity.User;
import com.chathura.lapmart.auth_server.enums.AppRole;
import com.chathura.lapmart.auth_server.exception.DuplicateEntyException;
import com.chathura.lapmart.auth_server.repo.RoleRepo;
import com.chathura.lapmart.auth_server.repo.UserRepo;
import com.chathura.lapmart.auth_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    @Override
    public void create(RequestUserDto dto) {
        if (userRepo.findByUsername(dto.getUsername()).isPresent()){
            throw new DuplicateEntyException("Username is already in use");
        }
        User user = toEntityUser(dto);
        userRepo.save(user);
    }

    private User toEntityUser(RequestUserDto dto){
        Role userRole = roleRepo.findByName(AppRole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Default Role not found!"));

        return   User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .enabled(true)
                .roles(Collections.singleton(userRole))
                .build();
    }
}
