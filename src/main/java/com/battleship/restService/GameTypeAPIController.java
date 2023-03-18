package com.battleship.restService;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.battleship.Controller.GameTypeController;
import com.battleship.restService.Response.GameTypeResponse;
import com.battleship.restService.Response.Response;


@RestController
public class GameTypeAPIController {

	@CrossOrigin(origins = "*")
	@GetMapping("/gametype")
	public ResponseEntity<Response> getGameTypes() {
		Message message = new Message();
		List<GameTypeResponse> gameTypes = GameTypeController.getAllGameTypes(message);

		Response response = new Response(message, gameTypes);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	@CrossOrigin(origins = "*")
	@GetMapping("/gametype/{id}")
	public ResponseEntity<Response> getGameType(@PathVariable int id) {
		Message message = new Message();
		GameTypeResponse gameType = GameTypeController.getGameTypeById(message, id);
		
		Response response = new Response(message, gameType);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}