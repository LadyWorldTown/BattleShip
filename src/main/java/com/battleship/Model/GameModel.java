package com.battleship.Model;
import java.util.ArrayList;

import com.battleship.DataAccess.BoardDataAccess;
import com.battleship.DataAccess.GameDataAccess;
import com.battleship.DataAccess.GameTypeDataAccess;
import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.DataAccess.ShipDataAccess;
import com.battleship.DataAccess.SpaceDataAccess;
import com.battleship.DataObject.BoardDataObject;
import com.battleship.DataObject.GameDataObject;
import com.battleship.DataObject.GameTypeDataObject;
import com.battleship.DataObject.PlayerDataObject;
import com.battleship.DataObject.ShipDataObject;
import com.battleship.DataObject.SpaceDataObject;
import com.battleship.DomainObject.BoardDomainObject;
import com.battleship.DomainObject.GameDomainObject;
import com.battleship.DomainObject.GameTypeDomainObject;
import com.battleship.DomainObject.PlayerDomainObject;
import com.battleship.DomainObject.ShipDomainObject;
import com.battleship.DomainObject.SpaceDomainObject;
import com.battleship.restService.Message;


public class GameModel {
	

	public static ArrayList<GameDomainObject> GetAllGameSummaries(Message message) {
		ArrayList<GameDataObject> gameDataList = GameDataAccess.getAllGames();
		ArrayList<GameDomainObject> gameDomainList = GameDomainObject.MapList(gameDataList);
		return gameDomainList;
	}

	public static GameDomainObject GetGameDetailsByGameIdandPlayerId(Message message, int gameId, int playerId) throws Exception {
		//Get the Game Details
		GameDataObject gameData = GameDataAccess.getGameById(gameId);
		GameDomainObject gameDomain = new GameDomainObject(gameData);

		boolean isPlayer1 = false;
		boolean isPlayer2 = false;

		if (playerId == gameDomain.Player1Id)
			isPlayer1 = true;
		else if (playerId == gameDomain.Player2Id)
			isPlayer2 = true;
		else {
			throw new Exception("Player " + playerId + " is not part of this game");
		}
		//Get the Board Details for Player 1 
		if (gameDomain.Board1Id > 0){
			BoardDomainObject board1Data = BoardModel.GetBoardDetailsById(message, gameDomain.Board1Id);
			gameDomain.Board1 = board1Data;
			if (isPlayer2) {
				gameDomain.Board1.ships = null;
			}
		}
		//Get the Board Details for Player 2 
		if (gameDomain.Board2Id > 0){
			BoardDomainObject board2Data = BoardModel.GetBoardDetailsById(message, gameDomain.Board2Id);
			gameDomain.Board2 = board2Data;
			if (isPlayer1) {
				gameDomain.Board2.ships = null;
			}
		}

		return gameDomain;
	}


	public static GameDomainObject GetGameById(Message message, int id) {
		GameDataObject gameData = GameDataAccess.getGameById(id);
		GameDomainObject gameDomain = new GameDomainObject(gameData);
		return gameDomain;
	}


	public static GameDomainObject CreateGame(Message message, GameDomainObject domainGameToCreate) {
		
		//Conditional checking for missing parameters
		if(domainGameToCreate.Player1Id == 0 || domainGameToCreate.Player2Id == 0
		|| domainGameToCreate.GameTypeId == 0) {
			message.addErrorMessage("Must include all parameters.");
			return domainGameToCreate;
		}

		//Check for Validity of Players and Game Type
		PlayerDataObject player1 = PlayerDataAccess.getPlayerById(domainGameToCreate.Player1Id);
		GameTypeDataObject gameType = GameTypeDataAccess.getGameTypeById(domainGameToCreate.GameTypeId);
		PlayerDataObject player2 = PlayerDataAccess.getPlayerById(domainGameToCreate.Player2Id);

		if(gameType == null) {
			message.addErrorMessage("The gametype is not valid.");
			return domainGameToCreate;
		}

		if(player1 == null) {
			message.addErrorMessage("Player 1 is not a valid player.");
			return domainGameToCreate;
		} else if(player2 == null) {
			message.addErrorMessage("Player 2 is not a valid player.");
			return domainGameToCreate;
		}

		//Create Game Object
		GameDataObject newGame = new GameDataObject(0, 0, domainGameToCreate.GameTypeId, -1, 
		"Board Setup", domainGameToCreate.Player1Id, domainGameToCreate.Player2Id, 0, 0);

		newGame = GameDataAccess.createGame(newGame);
		domainGameToCreate.Id = newGame.Id;
		domainGameToCreate.GameStatus = newGame.GameStatus;

		return domainGameToCreate;



	}

	public static GameDomainObject SetShips(Message message, int gameId, int playerId, ArrayList<ShipDomainObject> ships) {
		//To Be Written
		return null;
	}
	
	public static GameDomainObject TakeTurn(Message message, int gameId, int playerId, int column, int row) throws Exception {
		//To Be Written
		return null;
	}

}