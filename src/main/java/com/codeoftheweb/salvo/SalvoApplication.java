package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository, SalvoRepository salvoRepository) {
        return (args) -> {

            Game game0 = new Game(LocalDateTime.now());
            Game game1 = new Game(LocalDateTime.now());
            Game game2 = new Game(LocalDateTime.now());

            Player player0 = new Player("j.bauer@ctu.gov");
            Player player1 = new Player("c.obrian@ctu.gov");
            Player player2 = new Player("kim_bauer@gmail.com");
            Player player3 = new Player("t.almeida@ctu.gov");

            GamePlayer gamePlayer0 = new GamePlayer(LocalDateTime.now(), game0, player0);
            GamePlayer gamePlayer1 = new GamePlayer(LocalDateTime.now(), game0, player1);
            GamePlayer gamePlayer2 = new GamePlayer(LocalDateTime.now(), game1, player2);
            GamePlayer gamePlayer3 = new GamePlayer(LocalDateTime.now(), game1, player3);
            GamePlayer gamePlayer4 = new GamePlayer(LocalDateTime.now(), game2, player2);

            Ship ship0 = new Ship("Carrier", gamePlayer0, List.of("C1", "C2", "C3", "C4", "C5"));
            Ship ship1 = new Ship("Battleship", gamePlayer0, List.of("B7", "C7", "D7", "E7"));
            Ship ship2 = new Ship("Submarine", gamePlayer0, List.of("F2", "F3", "F4"));
            Ship ship3 = new Ship("Destroyer", gamePlayer0, List.of("H6", "I6", "J6"));
            Ship ship4 = new Ship("Patrol Boat", gamePlayer0, List.of("E9", "E10"));
            Ship ship5 = new Ship("Carrier", gamePlayer1, List.of("C1", "C2", "C3", "C4", "C5"));
            Ship ship6 = new Ship("Battleship", gamePlayer1, List.of("I1", "I2", "I3", "I4"));
            Ship ship7 = new Ship("Submarine", gamePlayer1, List.of("F2", "F3", "F4"));
            Ship ship8 = new Ship("Destroyer", gamePlayer1, List.of("A9", "B9", "C9"));
            Ship ship9 = new Ship("Patrol Boat", gamePlayer1, List.of("J8", "J9"));

            Salvo salvo0 = new Salvo(1, gamePlayer0, List.of("C1", "D3"));
            Salvo salvo1 = new Salvo(2, gamePlayer0, List.of("E7", "G2"));
            Salvo salvo2 = new Salvo(3, gamePlayer0, List.of("J9"));
            Salvo salvo3 = new Salvo(1, gamePlayer1, List.of("B7", "C3"));
            Salvo salvo4 = new Salvo(2, gamePlayer1, List.of("E8", "G3"));
            Salvo salvo5 = new Salvo(3, gamePlayer1, List.of("H7"));

            playerRepository.save(player0);
            playerRepository.save(player1);
            playerRepository.save(player2);
            playerRepository.save(player3);

            gameRepository.save(game0);
            gameRepository.save(game1);
            gameRepository.save(game2);

            gamePlayerRepository.save(gamePlayer0);
            gamePlayerRepository.save(gamePlayer1);
            gamePlayerRepository.save(gamePlayer2);
            gamePlayerRepository.save(gamePlayer3);
            gamePlayerRepository.save(gamePlayer4);

            shipRepository.save(ship0);
            shipRepository.save(ship1);
            shipRepository.save(ship2);
            shipRepository.save(ship3);
            shipRepository.save(ship4);
            shipRepository.save(ship5);
            shipRepository.save(ship6);
            shipRepository.save(ship7);
            shipRepository.save(ship8);
            shipRepository.save(ship9);

            salvoRepository.save(salvo0);
            salvoRepository.save(salvo1);
            salvoRepository.save(salvo2);
            salvoRepository.save(salvo3);
            salvoRepository.save(salvo4);
            salvoRepository.save(salvo5);

        };

    }
}