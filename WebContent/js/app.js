var gameTableView;
var gameList;
$(document).ready(function(){
	$('#kuangkuang').append(
    		new AddGameDetailsView({model: new Game({
    			gameid:'XXXX',
    			gamename:'X',
    			gamecompany:'X',
    			gameplatform:'X',
    			gameyear:'0000',
    			gamefeedback:'X'})}).render());
	gameList = new GameList();
	gameList.fetch({
		success: function(data){
			gameTableView = new GameTableView({collection: gameList});
		}
	});
});

