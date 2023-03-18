package com.battleship.DataObject;

public class ShipTypeDataObject {

	public int Id;
	public String ShipName;
	public int Length;


	public ShipTypeDataObject (int id, String shipName, int length) {
		this.Id = id;
		this.ShipName = shipName;
		this.Length = length;
	}
}