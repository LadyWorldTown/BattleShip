package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.ShipTypeDataObject;

public class ShipTypeDataAccess {

	private static ArrayList<ShipTypeDataObject> shipTypes;

	public ShipTypeDataAccess() {
		initialize();
	}

	private void initialize() {
		shipTypes = new ArrayList<ShipTypeDataObject>();
		
		//Aircraft Carrier
		shipTypes.add( new ShipTypeDataObject(1, "Aircraft Carrier", 5));
		//Battleship
		shipTypes.add( new ShipTypeDataObject(2, "Battleship", 4));
		//Cruiser
		shipTypes.add( new ShipTypeDataObject(3, "Cruiser", 3));
		//Submarine
		shipTypes.add( new ShipTypeDataObject(4, "Submarine", 3));
		//Destroyer
		shipTypes.add( new ShipTypeDataObject(5, "Destroyer", 2));
		//Frigate
		shipTypes.add( new ShipTypeDataObject(6, "Frigate", 2));
		
	}


	public static ArrayList<ShipTypeDataObject> getAllShipTypes() {
		return shipTypes;
	}

	public static ShipTypeDataObject getShipTypeById(int Id) {
		
		for (int i=0; i < shipTypes.size(); i++) {
			if (shipTypes.get(i).Id == Id) {
				return shipTypes.get(i);
			}
		}
		
		return null;
	}

}