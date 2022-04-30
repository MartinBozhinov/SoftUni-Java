package com.example.springautomappingexe.service;

import com.example.springautomappingexe.entity.UserLoginDto;
import com.example.springautomappingexe.entity.UserRegisterDto;

public interface UserService {


    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logOut();
}
