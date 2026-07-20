package com.chathura.lapmart.auth_server.config;

import com.chathura.lapmart.auth_server.entity.Role;
import com.chathura.lapmart.auth_server.enums.AppRole;
import com.chathura.lapmart.auth_server.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        if(roleRepo.count() == 0){
            Arrays.stream(AppRole.values()).forEach(appRole -> {
                Role role = Role.builder()
                        .name(appRole)
                        .build();
                roleRepo.save(role);
            });
        }
        System.out.println(">>> Database Seeding Complete: Default roles inserted successfully");
    }
}
