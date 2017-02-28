package testgame;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;

import gamethrone27.Game;
import testgame.RestApiHelper;
import testgame.RestResponse;
import testgame.UtilsDAOExt;

import gamethrone27.*;


public class RestAPITest {

	@Before
	public void setUp() {
		UtilsDAOExt utilsDAO = new UtilsDAOExt();
		utilsDAO.deleteTable();
		utilsDAO.addTwoRows();
	}

	@Test
	public void testGetGames() {
		String url = "http://localhost:8080/gamethrone/ashen/games";
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Game[] gamelist = new Gson().fromJson(response.getResponseBody(),
				Game[].class);
		assertEquals(4, gamelist.length);
		Game game = gamelist[0];
		Assert.assertEquals("WATCHDOGS 888", game.getGamename());
		Assert.assertEquals("UBISOFT", game.getGamecompany());
		Assert.assertEquals("PS4, XBOXONE, PC", game.getGameplatform());
		Assert.assertEquals("2016",game.getGameyear());
		Assert.assertEquals("9 STAR", game.getGamefeedback());
		game=gamelist[3];
		Assert.assertEquals("MA", game.getGamename());
		Assert.assertEquals("LAYERS", game.getGamecompany());
		Assert.assertEquals("WII", game.getGameplatform());
		
	}

	@Test
	public void testGetGameWithId() {
		String url = "http://localhost:8080/gamethrone/ashen/games/1";
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		/**
		 * 1. Use GSON builder class to get the instance of GSON class 2. Use
		 * the GSON object to deserialize the json
		 */
		Game game = new Gson().fromJson(response.getResponseBody(), Game.class);
		Assert.assertEquals("WATCHDOGS 888", game.getGamename());
		Assert.assertEquals("UBISOFT", game.getGamecompany());
		Assert.assertEquals("PS4, XBOXONE, PC", game.getGameplatform());
		Assert.assertEquals("2016",game.getGameyear());
		Assert.assertEquals("9 STAR", game.getGamefeedback());
	}

	@Test
	public void testPostGame() {
		String fileName = "TestDataFile.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		RestResponse response = RestApiHelper.performPostRequest(
				"http://localhost:8080/gamethrone/ashen/games", fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
		Game game = new Gson().fromJson(response.getResponseBody(), Game.class);
		String url = "http://localhost:8080/gamethrone/ashen/games/"
				+ game.getGameid();
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals("MARIO", game.getGamename());
		Assert.assertEquals("NINTENDO", game.getGamecompany());
		Assert.assertEquals("GBA", game.getGameplatform());
		Assert.assertEquals("2012",game.getGameyear());
		Assert.assertEquals("8 STAR", game.getGamefeedback());
		
	}

	@Test
	public void testPutGame() {
		String fileName ="TestDataPut.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		String url = "http://localhost:8080/gamethrone/ashen/games/1";
		RestResponse response = RestApiHelper.performPutRequest(url, fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Game game = new Gson().fromJson(response.getResponseBody(), Game.class);
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals("WATCHDOGS 123", game.getGamename());
		Assert.assertEquals("NINTENDO", game.getGamecompany());
		Assert.assertEquals("PS4", game.getGameplatform());
		Assert.assertEquals("2018",game.getGameyear());
		Assert.assertEquals("10 STAR", game.getGamefeedback());
	}

	@Test
	public void testDeleteGame() {
		String url = "http://localhost:8080/gamethrone/ashen/games/1";
		RestResponse response = RestApiHelper.performDeleteRequest(url);
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Game game = new Gson().fromJson(response.getResponseBody(), Game.class);
		Assert.assertEquals(null, game);
		url = "http://localhost:8080/gamethrone/ashen/games";
		response = RestApiHelper.performGetRequest(url, null);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Game[] gamelist = new Gson().fromJson(response.getResponseBody(),
				Game[].class);
		assertEquals(3, gamelist.length);
	}
}

 