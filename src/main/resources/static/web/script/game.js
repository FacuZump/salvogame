const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('gp');

fetch('http://localhost:8080/api/game_view/' + myParam)
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
        app.games = data;
        app.gpInfo();
        app.asignShipLocations();
        app.asignSalvoLocations();
        app.hitSalvo();
    })

var app = new Vue({
    el: '#app',
    data: {
        games: [],
        player1: [],
        player2: [],
        salvoPlayer1: [],
        salvoPlayer2: [],
        value: "s",
        letters: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
        numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    },
    methods: {
        asignShipLocations: function () {
            for (var i = 0; i < app.games.ships.length; i++) {
                for (var j = 0; j < app.games.ships[i].location.length; j++) {
                    document.getElementById(app.games.ships[i].location[j]).className = "ship" + i;
                }
            }
        },
        asignSalvoLocations: function () {
            app.salvoPlayer1 = app.games.salvoes.filter(elem1 => elem1.player == app.player1.id)
            app.salvoPlayer2 = app.games.salvoes.filter(elem2 => elem2.player == app.player2.id)

            for (var i = 0; i < app.salvoPlayer1.length; i++) {
                for (var j = 0; j < app.salvoPlayer1[i].locations.length; j++) {
                    document.getElementById(app.salvoPlayer1[i].locations[j] + "s").className = "salvo";
                    document.getElementById(app.salvoPlayer1[i].locations[j] + "s").innerHTML = app.salvoPlayer1[i].turn;
                }
            }
            for (var i = 0; i < app.salvoPlayer2.length; i++) {
                for (var j = 0; j < app.salvoPlayer2[i].locations.length; j++) {
                    document.getElementById(app.salvoPlayer2[i].locations[j]).className = "salvo";
                    document.getElementById(app.salvoPlayer2[i].locations[j]).innerHTML = app.salvoPlayer2[i].turn;
                }
            }
        },
        hitSalvo: function () {
            for (var i = 0; i < app.salvoPlayer2.length; i++) {
                for (var j = 0; j < app.salvoPlayer2[i].locations.length; j++) {
                    for (var k = 0; k < app.games.ships.length; k++) {
                        if (app.games.ships[k].location.includes(app.salvoPlayer2[i].locations[j])) {
                            document.getElementById(app.salvoPlayer2[i].locations[j]).className = "hitSalvo"
                            document.getElementById(app.salvoPlayer2[i].locations[j]).innerHTML = app.salvoPlayer2[i].turn;
                        }
                    }
                }
            }
        },
        gpInfo: function () {
            for (var i = 0; i < app.games.gamePlayers.length; i++) {
                if (app.games.gamePlayers[i].player.id == myParam) {
                    app.player1 = app.games.gamePlayers[i].player
                } else
                    app.player2 = app.games.gamePlayers[i].player
            }
        }
    }
})