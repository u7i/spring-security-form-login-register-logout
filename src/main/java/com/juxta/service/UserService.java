package com.juxta.service;

import com.juxta.dto.UserDto;
import com.juxta.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
