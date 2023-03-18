package com.battleship.restService;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.battleship.Controller.GameController;
import com.battleship.restService.Request.CreateGameRequest;
import com.battleship.restService.Request.SetShipsRequest;
import com.battleship.restService.Request.TakeTurnRequest;
import com.battleship.restService.Response.GameResponse;
import com.battleship.restService.Response.Response;


@RestController
public class GameAPIController {

//	@Autowired 
//	private Messaging messaging;

	
	@CrossOrigin(origins = "*")
	@GetMapping("/game")
	public ResponseEntity<Response> getGames() {
		Message message = new Message();
		List<GameResponse> games = GameController.getAllGames(message);

		Response response = new Response(message, games);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		

	}

	@CrossOrigin(origins = "*")
	@GetMapping("/game/{gameid}/player/{playerid}")
	public ResponseEntity<Response> getGame(@PathVariable int gameid, @PathVariable int playerid) {
		Message message = new Message();
		GameResponse game = GameController.getGameByGameIdAndPlayerId(message, gameid, playerid);
		
		Response response = new Response(message, game);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}


	@CrossOrigin(origins = "*")
	@PostMapping("/game")
	public ResponseEntity<Response> createGame(@RequestBody CreateGameRequest request) {
		Message message = new Message();
		GameResponse game = GameController.createGame(message, request);

		Response response = new Response(message, game);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	@CrossOrigin(origins = "*")
	@PostMapping("/game/{id}/ships")
	public ResponseEntity<Response> setShips(@PathVariable int id, @RequestBody SetShipsRequest request) {
		Message message = new Message();
		GameResponse game = GameController.setShips(message, id, request);

		Response response = new Response(message, game);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/game/{id}/taketurn")
	public ResponseEntity<Response> takeTurn(@PathVariable int id, @RequestBody TakeTurnRequest request) {
		Message message = new Message();
		GameResponse game = GameController.takeTurn(message, id, request);

		Response response = new Response(message, game);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}