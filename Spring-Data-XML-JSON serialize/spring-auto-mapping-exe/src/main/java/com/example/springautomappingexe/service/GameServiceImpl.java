package com.example.springautomappingexe.service;

import com.example.springautomappingexe.entity.Game;
import com.example.springautomappingexe.entity.GameAddDto;
import com.example.springautomappingexe.repository.GameRepository;
import com.example.springautomappingexe.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService{
     private final    GameRepository gameRepository;
     private final ModelMapper modelMapper;
     private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations
                = validationUtil.violations(gameAddDto);

        if (!violations.isEmpty()){
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto,Game.class);



    }
}
