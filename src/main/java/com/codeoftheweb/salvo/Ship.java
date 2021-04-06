package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Ship {

    private String Type;

    @ElementCollection
    @Column(name="location")
    private List<String> location = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne
    @JoinColumn(name = "gamePlayer_id")
    public GamePlayer gamePlayer;

    public Ship() {}

    public Ship(String shipType, GamePlayer gamePlayer, List<String> location) {
        this.Type = shipType;
        this.gamePlayer = gamePlayer;
        this.location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}