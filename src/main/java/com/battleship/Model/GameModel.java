package com.battleship.Model;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.battleship.DataAccess.BoardDataAccess;
import com.battleship.DataAccess.GameDataAccess;
import com.battleship.DataAccess.ShipDataAccess;
import com.battleship.DataAccess.SpaceDataAccess;
import com.battleship.DataObject.BoardDataObject;
import com.battleship.DataObject.GameDataObject;
import com.battleship.DataObject.ShipDataObject;
import com.battleship.DataObject.SpaceDataObject;
import com.battleship.DomainObject.BoardDomainObject;
import com.battleship.DomainObject.GameDomainObject;
import com.battleship.DomainObject.GameTypeDomainObject;
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
		//To Be Written 
			GameDataObject dataGameToCreate = new GameDataObject(0,0, domainGameToCreate.GameTypeId, 0, "Board Setup", domainGameToCreate.Player1Id, domainGameToCreate.Player2Id, 0, 0);
			GameDataObject dataCreatedGame = GameDataAccess.createGame(dataGameToCreate);
			
		return new GameDomainObject(dataCreatedGame);
	}
		

	public static GameDomainObject SetShips(Message message, int gameId, int playerId, ArrayList<ShipDomainObject> ships) {
		//To Be Written
		return null;
	}
	
	public static GameDomainObject TakeTurn(Message message, int gameId, int playerId, int column, int row) throws Exception {
		//To Be Written Tierra Anthony
		
		GameDomainObject gamesDomain = new GameDomainObject(GameDataAccess.getGameById(gameId));
	
		int hitSpaceId = (column + ((row - 1)*10)) - 1;
		boolean hitShip = false;
		

		//create spaces, domains, and ship's Data list for each player
		ArrayList<SpaceDataObject> spaceP1 = SpaceDataAccess.getSpacesForBoardId(gamesDomain.Board1Id);
		ArrayList<ShipDataObject> shipP1 = ShipDataAccess.getShipsForBoardId(gamesDomain.Board1Id);	
		
		ArrayList<SpaceDataObject> spaceP2 = SpaceDataAccess.getSpacesForBoardId(gamesDomain.Board2Id);
		ArrayList<ShipDataObject> shipP2 = ShipDataAccess.getShipsForBoardId(gamesDomain.Board2Id);

		ArrayList<ShipDomainObject> shipDomain1 = ShipDomainObject.MapFromDataList(shipP1);
		ArrayList<ShipDomainObject> shipDomain2 = ShipDomainObject.MapFromDataList(shipP2);

		if (gamesDomain.Player1Id == playerId){
			//Checks player 1's ship domain
			for (int i = 0; i < shipDomain2.size(); i++){
				ArrayList<Cell> cells = GetCellsForShip(shipDomain2.get(i));

				for(int j = 0; j < cells.size(); j++){
					if(column == cells.get(j).column && row == cells.get(j).row){
						hitShip = true;
						spaceP2.get(hitSpaceId).Status = "hit";
						shipP2.get(i).Length--;
						message.addInfoMessage("A ship has been hit!");
						
						//Check if ship is sunk already
						if(shipP2.get(i).Length == 0){
							message.addInfoMessage("You sunk a ship!");
						}
					}
		}		
	}
}else if(gamesDomain.Player2Id == playerId){
	//Checks player 2's ship domain
	for (int i = 0; i < shipDomain1.size(); i++){
			ArrayList<Cell> cells = GetCellsForShip(shipDomain1.get(i));
			for(int j = 0; j < cells.size(); j++){
				if(column == cells.get(j).column && row==cells.get(j).row){
						hitShip = true;
						spaceP1.get(hitSpaceId).Status = "hit";
						shipDomain1.get(i).Length = shipDomain1.get(i).Length - (j + 1);
						message.addInfoMessage("A ship has been hit!");		

						if(shipDomain1.get(i).Length == 0){
							message.addInfoMessage("You sunk a ship!");
						}
					}
				}
			}
		}
		// player misses
	if(gamesDomain.Player1Id == playerId && hitShip == false){
		spaceP2.get(hitSpaceId).Status = "miss"; 
		message.addInfoMessage("Miss");

	}else if(gamesDomain.Player2Id == playerId && hitShip == false){
		spaceP1.get(hitSpaceId).Status = "miss"; 
		message.addInfoMessage("Miss");

}
	return gamesDomain;
}


	public static class Cell {
        public int column;
        public int row;
    }

    public static ArrayList<Cell> GetCellsForShip (ShipDomainObject ship) {
        ArrayList<Cell> cells = new ArrayList<Cell>();

        Cell cell = null;

        for (int i=0; i< ship.Length; i++) {    
            if (ship.IsVertical) {
                cell = new Cell();
                cell.column = ship.StartCol;
                cell.row = ship.StartRow + i;
            }
            else {
                cell = new Cell();
                cell.column = ship.StartCol + i;
                cell.row = ship.StartRow ;
            }
            cells.add(cell);
        }

        return cells;
    }
	
    

}