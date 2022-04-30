package com.example.springautomappingexe.configuration;

import com.example.springautomappingexe.entity.Game;
import com.example.springautomappingexe.entity.GameAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper.map(GameAddDto::getThubnailURL,Game::setThumbnail));


        return modelMapper;
    }

}
