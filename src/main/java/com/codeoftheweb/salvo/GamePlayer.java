package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private LocalDateTime LocalDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    public Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    public Game game;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gamePlayer")
    private Set<Ship> ships = new HashSet<>();

    public GamePlayer() {
    }

    public GamePlayer(LocalDateTime localDate, Game game, Player player) {
        this.LocalDate = localDate;
        this.player = player;
        this.game = game;
    }

    public void AddShip(Ship ship) {
        ship.setGamePlayer(this);
        ships.add(ship);
    }

    public LocalDateTime getLocalDate() {
        return LocalDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLocalDate(LocalDateTime localDate) {
        LocalDate = localDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Ship> getShip() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

}

