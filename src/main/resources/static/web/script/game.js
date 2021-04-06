const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('gp');

fetch('http://localhost:8080/api/game_view/' + myParam)
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
        app.games = data;
        app.asignLocation();
        app.gpInfo();
    })

var app = new Vue({
    el: '#app',
    data: {
        games: [],
        actualPlayer: null,
        vsPlayer: null,
        letters: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
        numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    },
    methods: {
        asignLocation: function () {
            for (var i = 0; i < app.games.ships.length; i++) {
                for (var j = 0; j < app.games.ships[i].location.length; j++) {
                    document.getElementById(app.games.ships[i].location[j]).className = "ship" + i;
                }
            }
        },
        gpInfo: function () {
            for (var i = 0; i < app.games.gamePlayers.length; i++) {
                if (app.games.gamePlayers[i].player.id == myParam) {
                    app.actualPlayer = app.games.gamePlayers[i].player.email
                } else
                    app.vsPlayer = app.games.gamePlayers[i].player.email
            }
        }
    }
})