package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "player_id")
    public Player player;

    @ManyToOne
    @JoinColumn(name = "game")
    public Game game;

    public Score() {}

    public Score(long id, Integer score, Player player, Game game) {
        this.id = id;
        this.score = score;
        this.player = player;
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
}