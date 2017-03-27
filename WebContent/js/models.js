var baseUrl = 'ashen/games';

var Game = Backbone.Model.extend({
    urlRoot: baseUrl,
    idAttribute:'gameid',
    defaults: {
    	"gameid": "",
        "gamename": "",
        "gamecompany": "",
        "gameplatform": "",
        "gameyear": "",
        "gamefeedback": ""
    },
    initialize: function () {
        console.log('Surprise!!!!');
    }
});

var GameList = Backbone.Collection.extend({
    model: Game,
    url: baseUrl
});
