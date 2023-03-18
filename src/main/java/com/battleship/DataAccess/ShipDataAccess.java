package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.ShipDataObject;

public class ShipDataAccess {

	private static ArrayList<ShipDataObject> ships;

	public ShipDataAccess() {
		initialize();
	}

	private void initialize() {
		ships = new ArrayList<ShipDataObject>();
	
		
		//Board 1 AirCraft Carrier
		ships.add(new ShipDataObject(getNextId(), 1, 1, 5, false, 2, 10));
		//Board 1 Battleship
		ships.add(new ShipDataObject(getNextId(), 1, 2, 4, true, 2, 2));
		//Board 1 Cruiser
		ships.add(new ShipDataObject(getNextId(), 1, 3, 3, false, 8, 1));
		//Board 1 Submarine
		ships.add(new ShipDataObject(getNextId(), 1, 4, 3, false, 6, 6));
		//Board 1 Destroyer
		ships.add(new ShipDataObject(getNextId(), 1, 5, 2, false, 6, 8));

		//Board 2 AirCraft Carrier
		ships.add(new ShipDataObject(getNextId(), 2, 1, 5, false, 3, 4));
		//Board 2 Battleship
		ships.add(new ShipDataObject(getNextId(), 2, 2, 4, false, 2, 1));
		//Board 2 Cruiser
		ships.add(new ShipDataObject(getNextId(), 2, 3, 3, true, 2, 7));
		//Board 2 Submarine
		ships.add(new ShipDataObject(getNextId(), 2, 4, 3, true, 10, 1));
		//Board 2 Destroyer
		ships.add(new ShipDataObject(getNextId(), 2, 5, 2, false, 7, 9));

			
	}

	private static int getNextId() {
		return ships.size()+1;
	}

 	private static ShipDataObject getShipById(int Id) {
		
		for (int i=0; i < ships.size(); i++) {
			if (ships.get(i).Id == Id) {
				return ships.get(i);
			}
		}
		return null;
	}

	public static ArrayList<ShipDataObject> getShipsForBoardId(int boardId) {
		ArrayList<ShipDataObject> shipsForBoard = new ArrayList<ShipDataObject>();

		for (int i=0; i < ships.size(); i++) {
			if (ships.get(i).BoardId == boardId) {
				shipsForBoard.add(ships.get(i));
			}
		}
		
		return shipsForBoard;
	}

	public static ShipDataObject createShip(ShipDataObject data) {
		//To Be Written
		return null;
	}

}