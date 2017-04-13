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
            
        },this);
        $('#game-table').DataTable();
    }
});
var GameRowView=Backbone.View.extend({
    model:Game,
    tagName:'tr',
    events:{},
    render:function () {
        var template=_.template($('#gamebiao').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});