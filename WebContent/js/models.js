var baseUrl = 'ashen/games';

var Game = Backbone.Model.extend({
    urlRoot: baseUrl,
    idAttribute:'gameid',
    defaults: {
    	"gameid": "",
        "gamename": 0,
        "gamecompany": "",
        "gameplatform": "",
        "gameyear": "none",
        "gamefeedback": 0
    },
    initialize: function () {
        // LOG
        console.log('Surprise!!!!');
    }
});

var GameList = Backbone.Collection.extend({
    model: Game,
    url: baseUrl
});
