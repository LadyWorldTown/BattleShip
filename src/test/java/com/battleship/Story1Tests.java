package com.battleship;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.battleship.Controller.PlayerController;
import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.restService.Message;
import com.battleship.restService.Request.RegisterPlayerRequest;
import com.battleship.restService.Response.PlayerResponse;

class Story1Tests {

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

	String CreateRandomUsername() {
		return "username" + (long)Math.floor((Math.random()*10000000000L));
	}


	@BeforeEach
	void Setup() {
		PlayerDataAccess playerDataAccess = new PlayerDataAccess();
	}	


	/*
	 * 1.0
     * "Create Player - Valid"
     * "Call createPlayer with a valid username, password.  Verify the return id is correct."
	 */
	@Test
	void Test_CreatePlayer_Valid() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = CreateRandomUsername();
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() == 0, "Register Player should be successful" );
		int nextId = player.getPlayerId() + 1;

		//Setup Part 2 of the test.		
		username = CreateRandomUsername();
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
		
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() == 0, "Register Player should be successful" );
		assertTrue(player.getPlayerId() == nextId, "created player id is not sequential." );
		assertTrue(player.getUsername() == username, String.format("Response username should be %s", username));
	}

	/*
	 * 1.1,
     * "Create Player - Dupe Username", 
     * "Call createPlayer with a valid username, password, Then call create player again with the same username.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreatePlayer_DupeUsername() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = CreateRandomUsername();
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() == 0, "Register Player should be successful" );


		//Setup Part 2 of the test.		
		//username =   Do not change the username.  
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
		
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  There is a duplicate username." );
		assertTrue(message.getErrorMessage().contains("Username is already taken.  Please select another."), "Incorrect Error Message provided." );
	}


	/*
     * 1.2,
     * "Create Player - Username is 8-25 characters", 
     * "Call createPlayer with a username that is too short and too long.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreatePlayer_UsernameSize() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = "short";
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The username is too short." );
		assertTrue(message.getErrorMessage().contains("Username must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );


		//Setup Part 2 of the test.		
		username = "UserNameMoreThanTwentyFive";
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
		
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The username is too long" );
		assertTrue(message.getErrorMessage().contains("Username must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );
	}

	/*
     * 1.3
	 * Create Player - Username cannot contain symbols", 
     * "Call createPlayer with a username that contains symbols.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreatePlayer_UsernameSymbols() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = "user.name";
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The username contains symbols" );
		assertTrue(message.getErrorMessage().contains("Username must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );


		//Setup Part 2 of the test.		
		username = "user$name";
		password = "password";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The username contains symbols" );
		assertTrue(message.getErrorMessage().contains("Username must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );

	}

	/*
     * 1.4,
     * "Create Player - Password is 8-25 characters", 
     * "Call createPlayer with a password that is too short and too long.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreatePlayer_PasswordSize() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = CreateRandomUsername();
		password = "short";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The password is too short." );
		assertTrue(message.getErrorMessage().contains("Password must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );


		//Setup Part 2 of the test.		
		
		username = CreateRandomUsername();
		password = "PasswordMoreThanTwentyFive";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
		
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The password is too long." );
		assertTrue(message.getErrorMessage().contains("Password must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );
	}

	/*
     * 1.5
	 * Create Player - Password cannot contain symbols", 
     * "Call createPlayer with a password that contains symbols.  Verify the proper error is returned.", 
	 */
	@Test
	void Test_CreatePlayer_PasswordSymbols() {

		RegisterPlayerRequest request;
		String username, password;
		PlayerResponse player;

		//Setup Part 1 of the test.
		username = CreateRandomUsername();
		password = "pass.word";
		request = new RegisterPlayerRequest(username, password);
		Message message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The password contains symbols" );
		assertTrue(message.getErrorMessage().contains("Password must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );


		//Setup Part 2 of the test.		
		username = CreateRandomUsername();
		password = "pass$word";
		request = new RegisterPlayerRequest(username, password);
		message = new Message();
	
		player = PlayerController.registerPlayer(message, request);

		assertTrue(message.getErrorMessage().size() > 0, "Register Player should not have been successful.  The password contains symbols" );
		assertTrue(message.getErrorMessage().contains("Password must contain 8-25 characters - including only English letters and numbers."), "Incorrect Error Message provided." );

	}


}
