package com.battleship.Controller;

import com.battleship.restService.Request.SetShipsRequest;
import com.battleship.restService.Request.TakeTurnRequest;

import java.util.ArrayList;


import com.battleship.DomainObject.GameDomainObject;
import com.battleship.DomainObject.ShipDomainObject;
import com.battleship.Model.GameModel;
import com.battleship.restService.Message;
import com.battleship.restService.Request.CreateGameRequest;
import com.battleship.restService.Response.GameResponse;

public class GameController {
	//The GameController will convert the request from the REST Request and the Domain Model.
	//Then it will call the Model or Service, and convert the response from the Domain model
	//to the REST Response.
	public static ArrayList<GameResponse> getAllGames(Message message) {
		try {
			ArrayList<GameDomainObject> domain = GameModel.GetAllGameSummaries(message);
			ArrayList<GameResponse> response = GameResponse.MapList(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}
	public static GameResponse getGameByGameIdAndPlayerId(Message message, int gameId, int playerId) {
		try {
			GameDomainObject domain = GameModel.GetGameDetailsByGameIdandPlayerId(message, gameId, playerId);
			GameResponse response = new GameResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}
	public static GameResponse createGame(Message message, CreateGameRequest request) {
		try {
			GameDomainObject newGame = new GameDomainObject(request);

			GameDomainObject domain = GameModel.CreateGame(message, newGame);
			GameResponse response = new GameResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}

	public static GameResponse setShips(Message message, int gameId, SetShipsRequest request) {
		try {
			ArrayList<ShipDomainObject> ships = ShipDomainObject.MapFromRequestList(request.getShipLocations());
			GameDomainObject domain = GameModel.SetShips(message, gameId, request.getPlayerId(), ships);
			return getGameByGameIdAndPlayerId(message, gameId, request.getPlayerId());
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}


	}

	public static GameResponse takeTurn(Message message, int gameId, TakeTurnRequest request) {
		try {
			GameDomainObject domain = GameModel.TakeTurn(message, gameId, request.getPlayerId(), request.getColumn(), request.getRow());
			GameResponse game = getGameByGameIdAndPlayerId(message, gameId, request.getPlayerId());
			return game;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}


}
