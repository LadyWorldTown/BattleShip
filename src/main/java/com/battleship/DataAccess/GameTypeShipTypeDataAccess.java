package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.GameTypeShipTypeDataObject;

public class GameTypeShipTypeDataAccess {

	public GameTypeShipTypeDataAccess() {
		initialize();
	}

	private void initialize() {
		gameTypeShipTypes = new ArrayList<GameTypeShipTypeDataObject>();
		
		//Classic Aircraft Carrier
		gameTypeShipTypes.add(new GameTypeShipTypeDataObject(1, 1));
		//Classic Battleship
		gameTypeShipTypes.add(new GameTypeShipTypeDataObject(1, 2));
		//Classic Cruiser
		gameTypeShipTypes.add(new GameTypeShipTypeDataObject(1,3));
		//Classic Submarine
		gameTypeShipTypes.add(new GameTypeShipTypeDataObject(1, 4));
		//Classic Destroyer
		gameTypeShipTypes.add(new GameTypeShipTypeDataObject(1, 5));

	}

	private static ArrayList<GameTypeShipTypeDataObject> gameTypeShipTypes;

	public static ArrayList<GameTypeShipTypeDataObject> getAllShipTypesForGameType(int gameTypeId) {
		ArrayList<GameTypeShipTypeDataObject> gameTypeShipTypeList = new ArrayList<GameTypeShipTypeDataObject>();

		for (int i=0; i < gameTypeShipTypes.size(); i++) {
			if (gameTypeShipTypes.get(i).gameTypeId == gameTypeId) {
				gameTypeShipTypeList.add(gameTypeShipTypes.get(i));
			}
		}
		
		return gameTypeShipTypeList;
	}

}