package com.project.project_management.service.impl;

import com.project.project_management.converter.UserConverter;
import com.project.project_management.dto.UserDTO;
import com.project.project_management.entity.UserEntity;
import com.project.project_management.repository.UserRepository;
import com.project.project_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity=userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO loginUser(String email, String password) {
        return null;
    }
}
