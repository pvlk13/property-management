package com.project.project_management.service.impl;

import com.project.project_management.converter.UserConverter;
import com.project.project_management.dto.UserDTO;
import com.project.project_management.entity.UserEntity;
import com.project.project_management.exception.BusinessException;
import com.project.project_management.exception.ErrorModel;
import com.project.project_management.repository.UserRepository;
import com.project.project_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        Optional<UserEntity> optentity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optentity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL ALREADY EXISTS");
            errorModel.setMessage("The email is already registered!!");
            errorModelList.add(errorModel);
            try {
                throw new BusinessException(errorModelList);
            } catch (BusinessException e) {
                throw new RuntimeException(e);
            }
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity=userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO loginUser(String ownerEmail, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(ownerEmail, password);
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);
            try {
                throw new BusinessException(errorModelList);
            } catch (BusinessException e) {
                throw new RuntimeException(e);
            }
        }
        return userDTO;
    }
}
