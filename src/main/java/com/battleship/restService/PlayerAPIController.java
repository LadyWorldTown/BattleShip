package com.battleship.restService;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.battleship.Controller.PlayerController;
import com.battleship.restService.Request.RegisterPlayerRequest;
import com.battleship.restService.Response.PlayerResponse;
import com.battleship.restService.Response.Response;

@RestController
public class PlayerAPIController {

	@CrossOrigin(origins = "*")
	@GetMapping("/player")
	public ResponseEntity<Response> getPlayers() {
		Message message = new Message();
		List<PlayerResponse> players = PlayerController.getAllPlayers(message);
		
		Response response = new Response(message, players);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/player/{id}")
	public ResponseEntity<Response> getPlayer(@PathVariable int id) {
		Message message = new Message();
		PlayerResponse player = PlayerController.getPlayerById(message, id);

		Response response = new Response(message, player);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/player")
	public ResponseEntity<Response> registerPlayer(@RequestBody RegisterPlayerRequest request) {
		Message message = new Message();
		PlayerResponse player = PlayerController.registerPlayer(message, request);
		
		Response response = new Response(message, player);
		if (response.getSuccess())
			return ResponseEntity.status(HttpStatus.OK).body(response);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}