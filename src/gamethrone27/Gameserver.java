package gamethrone27;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/games")
@Stateless
@LocalBean
public class Gameserver {
	@EJB
	private GameDAO gamedao;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getallgame(){
		List<Game> games = gamedao.getallGames();
		return Response.status(200).entity(games).build();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response getonegame(@PathParam("id") int id){
		Game game = gamedao.getonegame(id);
		return Response.status(200).entity(game).build();
		
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response addgame(Game game){
		gamedao.add(game);
		return Response.status(201).entity(game).build();
		
	}
	
	@PUT
	@Consumes("application/json")
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response updategame(Game game){
		gamedao.update(game);
		return Response.status(200).entity(game).build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteonegame(@PathParam("id") int id){
		gamedao.delete(id);
		return Response.status(204).build();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/search/name/{n}")
	public Response getGameByName(@PathParam("n") String n)
	{
		List<Game> Games=gamedao.getGameByName(n);
		return Response.ok(Games).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/search/company/{c}")
	public Response getGameByCompany(@PathParam("c") String c)
	{
		List<Game> Games=gamedao.getGameByCompany(c);
		return Response.ok(Games).build();
	}
	
}
