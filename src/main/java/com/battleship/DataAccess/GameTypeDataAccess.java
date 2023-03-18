package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.GameTypeDataObject;

public class GameTypeDataAccess {
	
	private static ArrayList<GameTypeDataObject> gameTypes;
	
	public GameTypeDataAccess() {
		initialize();
	}

	private void initialize() {
		gameTypes = new ArrayList<GameTypeDataObject>();
		//Default Data
		//Classic
		gameTypes.add(new GameTypeDataObject(1, "Classic", 10, 10));
	}



	public static ArrayList<GameTypeDataObject> getAllGameTypes() {
		return gameTypes;
	}

	public static GameTypeDataObject getGameTypeById(int Id) {
		
		for (int i=0; i < gameTypes.size(); i++) {
			if (gameTypes.get(i).Id == Id) {
				return gameTypes.get(i);
			}
		}
		
		return null;
	}

}