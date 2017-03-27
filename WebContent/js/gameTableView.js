var GameTableView = Backbone.View.extend({
    collection: GameList,
    initialize: function () {
        this.listenTo(this.collection, 'add', this.renderList);
        this.render();
    },
    render: function () {
        this.collection.each(function (game) {
            $('#game-tbody').append(
                new GameRowView({ model: game }).render()
            );
            $('#kuangkuang').append(
            		new GameDetailsView({model: game}).render());
        }, this);
        $('#game-table').DataTable();
    },
    renderTable: function () {
        $('#game-table').DataTable().destroy();
        $('#game-tbody tr').remove();
        this.collection.each(function (games) {
            $('#game-tbody').append(
            		new GameRowView({ model: games }).render());
            
        });
        $('#game-table').DataTable();
    }
});