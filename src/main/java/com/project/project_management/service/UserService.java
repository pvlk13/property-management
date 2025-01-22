
package com.project.project_management.service;
import com.project.project_management.dto.UserDTO;


public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO loginUser(String email,String password);
}
