package com.example.springautomappingexe;

import com.example.springautomappingexe.entity.GameAddDto;
import com.example.springautomappingexe.entity.UserLoginDto;
import com.example.springautomappingexe.entity.UserRegisterDto;
import com.example.springautomappingexe.service.GameService;
import com.example.springautomappingexe.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;


    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter desired command:");
        String[] commands = bufferedReader.readLine().split("\\|");

         while (true){

             switch (commands[0]){
                 case "RegisterUser" -> userService.registerUser(new UserRegisterDto(commands[1]
                         ,commands[2],commands[3],commands[4]));
                 case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1],commands[2]));
                 case "Logout" -> userService.logOut();
                 case "AddGame" -> gameService.addGame(new GameAddDto(commands[1], new BigDecimal(commands[2])
                 ,Double.parseDouble(commands[3]),commands[4],commands[5],commands[6],
                         LocalDate.parse(commands[7])));
             }

         }

    }
}
