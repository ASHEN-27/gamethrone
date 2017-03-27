var GameRowView=Backbone.View.extend({
    model:Game,
    tagName:'tr',
    events:{},
    render:function () {
        var template=_.template($('#gamebiao').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});