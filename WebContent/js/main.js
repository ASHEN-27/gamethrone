$(document).ready(function(){
	$.ajax({
		url:"ashen/games",
		type:'GET',
		dataType:"json",
		success:renderTable});
	
})
function renderTable(data){
	$.each(data,function(index,games){
		$('#game-tbody').
		append('<tr><td>'+games.gamename+'</td><td>'
				+games.gamecompany+'</td><td>'
				+games.gameplatform+'</td><td>'
				+games.gameyear+'</td><td>'
				+games.gamefeedback+'</td></tr>')
	});
	$('#game-table').DataTable();
}