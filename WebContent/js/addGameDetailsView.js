var AddGameDetailsView = Backbone.View.extend({
    model: Game,
    tagName: 'div',
    events: {
        'click .btn-save': 'saveGame',
    },
    saveGame: function() {
        var id = 'XXXX';
        var gDetails = {
        	gameid: null,
            gamename: $('#gamename-' + id).val(),
            gamecompany: $('#gamecompany-' + id).val(),
            gameplatform: $('#gameplatform-' + id).val(),
            gameyear: $('#gameyear-' + id).val(),
            gamefeedback: $('#gamefeedback-' + id).val()
        };
        this.model=new Game(gDetails);
        this.model.save(gDetails, {
            success: function(games,yooooooo) {
            	gameList.add(yooooooo);
                console.info('successfully added, id: '+yooooooo.gameid);
                $('#kuangkuang').append(
                		new GameDetailsView({model: new Game(yooooooo)}).render());
                gameTableView.renderTable();
            },
            error: function(Game, response) {
                console.error('fail to add: ' + response.statusText);

            }
        });
    },
    render: function() {
        console.log("GameDetailsView.render")
        var template = _.template($('#gameneirong').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});