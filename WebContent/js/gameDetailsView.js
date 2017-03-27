var GameDetailsView = Backbone.View.extend({
    model: Game,
    tagName: 'div',
    events: {
        'click .btn-save': 'savegame',
        'click .btn-delete': 'deletegame'
    },
    savegame: function() {
        var id = this.model.get("gameid");
        console.info('saving ' + id + ':' + this.model.get('gamename'));
        var gDetails = {
            gameid: id,
            gamename: $('#gamename-' + id).val(),
            gamecompany: $('#gamecompany-' + id).val(),
            gameplatform: $('#gameplatform-' + id).val(),
            gameyear: $('#gameyear-' + id).val(),
            gamefeedback: $('#gamefeedback-' + id).val()
        };
        this.model.save(gDetails, {
            success: function(games) {
                console.info('success surprise~');
                gameTableView.renderTable();
            },
            error: function(games, response) {
                console.error('fail to update: ' + response.statusText);

            }
        });
        console.log(gDetails);
    },
    deletegame: function() {
        var id = this.model.get('gameid');
        console.info('deleteing ' + id + ': ' + this.model.get('gamename'));
        this.model.destroy({
            success: function(game) {
            	gameList.remove(id);
                console.info(game.get('gameid') + ' deleted.');
                gameTableView.renderTable();
            }
        });
    },
    render: function() {
        console.log("GameDetailsView.render")
        var template = _.template($('#gameneirong').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});