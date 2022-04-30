package com.example.xmlprocexe.service;

import com.example.xmlprocexe.model.dto.UserSeedDto;
import com.example.xmlprocexe.model.entity.User;

import java.util.List;

public interface UserService {


    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

}
