package com.battleship;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.battleship.Controller.GameController;
import com.battleship.Controller.PlayerController;
import com.battleship.DataAccess.GameDataAccess;
import com.battleship.DataAccess.GameTypeDataAccess;
import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.restService.Message;
import com.battleship.restService.Request.CreateGameRequest;
import com.battleship.restService.Request.RegisterPlayerRequest;
import com.battleship.restService.Response.GameResponse;
import com.battleship.restService.Response.PlayerResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Story6Tests {

/*
	GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
	GameTypeShipTypeDataAccess GameTypeShipTypeDataAccess = new GameTypeShipTypeDataAccess();
	ShipTypeDataAccess shipTypeDataAccess = new ShipTypeDataAccess();
	PlayerDataAccess playerDataAccess = new PlayerDataAccess();
	ShipDataAccess shipDataAccess = new ShipDataAccess();
	SpaceDataAccess spaceDataAccess = new SpaceDataAccess();
	BoardDataAccess boardDataAccess = new BoardDataAccess();
	GameDataAccess gameDataAccess = new GameDataAccess();
*/


	void Setup() {
		GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
		PlayerDataAccess playerDataAccess = new PlayerDataAccess();
		GameDataAccess gameDataAccess = new GameDataAccess();
	}	


	/*
	 * 6.0, 
     * "Create Game - Valid", 
     * "Call createGame with a valid player1, player2, and gametypeId.  Verify the return id is correct.", 
	 */
	@Test
	void Test_CreateGame_Valid() {
		Setup();

		CreateGameRequest request;
		int player1id, player2id, gametypeid;
		GameResponse game;

		//Setup Part 1 of the test.
		player1id = 1;
		player2id = 2;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		Message message = new Message();
	
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() == 0, "Create Game should have been successful" );
		int nextId = game.getGameId() + 1;

		//Setup Part 2 of the test.		
		player1id = 1;
		player2id = 2;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		message = new Message();
		
		game = GameController.createGame(message, request);
		assertTrue(message.getErrorMessage().size() == 0, "Create Game should have been successful" );
		assertTrue(game.getGameId() == nextId, "created game id is not sequential." );
		assertTrue(game.getStatus() == "Board Setup", "Game status should be returned as 'Board Setup'");

		assertTrue(game.getPlayer1Id() == player1id, String.format("Response player1id should be %d", player1id));
		assertTrue(game.getPlayer2Id() == player2id, String.format("Response player2id should be %d", player2id));
		assertTrue(game.getGameTypeId() == gametypeid, String.format("Response gametypeid should be %d", gametypeid));

		assertTrue(game.getWinner() <= 0, "Response winner should not be set");
		assertTrue(game.getPlayerTurn() <= 0, "Response playerturn should not be set");

	}

	/*
	 * 6.1, 
     * "Create Game - Missing fields", 
     * "Call createGame with a missing player1, player2, or gametypeId.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreateGame_MissingFields() {
		Setup();

		CreateGameRequest request;
		int player1id, player2id, gametypeid;
		GameResponse game;

		//Setup Part 1 of the test.

		player1id = 0;
		player2id = 2;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);

		Message message = new Message();
	
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, player 1 missing" );
		assertTrue(message.getErrorMessage().contains("Must include all parameters."), "Incorrect Error Message provided." );

		//Setup Part 2 of the test.		
		player1id = 1;
		player2id = 0;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		message = new Message();
		
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, player 2 missing" );
		assertTrue(message.getErrorMessage().contains("Must include all parameters."), "Incorrect Error Message provided." );

		//Setup Part 3 of the test.		
		player1id = 1;
		player2id = 2;
		gametypeid = 0;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		message = new Message();
		
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, game type missing" );
		assertTrue(message.getErrorMessage().contains("Must include all parameters."), "Incorrect Error Message provided." );
	
	}


	/*
	 * 6.2, 
     * "Create Game - Invalid fields", 
     * "Call createGame with an invalid player1, player2, or gametypeId.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreateGame_InvalidFields() {
		Setup();

		CreateGameRequest request;
		int player1id, player2id, gametypeid;
		GameResponse game;

		//Setup Part 1 of the test.
		player1id = 1645;
		player2id = 2;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		Message message = new Message();
	
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, player 1 is invalid" );
		assertTrue(message.getErrorMessage().contains("Player 1 is not a valid player."), "Incorrect Error Message provided." );

		//Setup Part 2 of the test.		
		player1id = 1;
		player2id = 1645;
		gametypeid = 1;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		message = new Message();
		
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, player 2 is invalid" );
		assertTrue(message.getErrorMessage().contains("Player 2 is not a valid player."), "Incorrect Error Message provided." );

		//Setup Part 3 of the test.		
		player1id = 1;
		player2id = 2;
		gametypeid = 1645;
		request = new CreateGameRequest(player1id, player2id, gametypeid);
		message = new Message();
		
		game = GameController.createGame(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Service should have failed, game type is invalid" );
		assertTrue(message.getErrorMessage().contains("The gametype is not valid."), "Incorrect Error Message provided." );
		
	}


}
