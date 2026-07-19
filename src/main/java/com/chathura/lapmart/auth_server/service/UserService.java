package com.chathura.lapmart.auth_server.service;

import com.chathura.lapmart.auth_server.dto.request.RequestUserDto;

public interface UserService {
    public void create(RequestUserDto dto);
}
