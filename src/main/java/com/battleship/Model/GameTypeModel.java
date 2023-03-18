package com.battleship.Model;
import java.util.ArrayList;

import com.battleship.DataAccess.GameTypeDataAccess;
import com.battleship.DataAccess.GameTypeShipTypeDataAccess;
import com.battleship.DataAccess.ShipTypeDataAccess;
import com.battleship.DataObject.GameTypeDataObject;
import com.battleship.DataObject.GameTypeShipTypeDataObject;
import com.battleship.DataObject.ShipTypeDataObject;
import com.battleship.DomainObject.GameTypeDomainObject;
import com.battleship.DomainObject.ShipTypeDomainObject;
import com.battleship.restService.Message;



public class GameTypeModel {
	
	public static GameTypeDomainObject GetGameTypeById(Message message, int id) {
		GameTypeDataObject gameTypeData = GameTypeDataAccess.getGameTypeById(id);
		GameTypeDomainObject gameTypeDomain = new GameTypeDomainObject(gameTypeData);
		
		gameTypeDomain.ships = getShipTypesForGameType(message, gameTypeDomain.Id);
		
		return gameTypeDomain;
	}

	public static ArrayList<GameTypeDomainObject> GetAllGameTypes(Message message) {
		ArrayList<GameTypeDataObject> gameTypeDataList = GameTypeDataAccess.getAllGameTypes();
		ArrayList<GameTypeDomainObject> gameTypeDomainList = GameTypeDomainObject.MapList(gameTypeDataList);
		
		for (int i=0; i<gameTypeDomainList.size(); i++) {
			gameTypeDomainList.get(i).ships = getShipTypesForGameType(message, gameTypeDomainList.get(i).Id);
		}
		
		return gameTypeDomainList;
	}


	private static ArrayList<ShipTypeDomainObject> getShipTypesForGameType(Message message, int gameTypeId) {

		ArrayList<GameTypeShipTypeDataObject> gameTypeShipTypes = GameTypeShipTypeDataAccess.getAllShipTypesForGameType(gameTypeId);

		ArrayList<ShipTypeDataObject> shipTypes = new ArrayList<ShipTypeDataObject>();
		for (int i=0; i<gameTypeShipTypes.size(); i++) {
			int shipTypeId = gameTypeShipTypes.get(i).shipTypeId;

			shipTypes.add(ShipTypeDataAccess.getShipTypeById(shipTypeId));
		}

		return ShipTypeDomainObject.MapList(shipTypes);
		
	}

}