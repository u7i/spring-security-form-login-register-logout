package com.juxta.service.impl;


import com.juxta.dto.UserDto;
import com.juxta.model.Role;
import com.juxta.model.User;
import com.juxta.repository.RoleRepository;
import com.juxta.repository.UserRepository;
import com.juxta.service.UserService;
import com.juxta.util.ERole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(ERole.ROLE_USER);

        if (role == null) {
            role = roleRepository.save(new Role(ERole.ROLE_USER));
        }

        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), role);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
