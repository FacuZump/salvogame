package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    public LocalDateTime creationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    private Set<GamePlayer> gamePlayers = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    private Set<Score> scores = new HashSet<>();

    public Game() {
    }

    public Game(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void AddGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }

    public List<Player> getPlayers() {
        return gamePlayers.stream().map(sub -> sub.getPlayer()).collect(toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

}