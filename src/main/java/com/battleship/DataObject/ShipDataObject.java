package com.battleship.DataObject;

public class ShipDataObject {

	public int Id;
	public int BoardId;
	public int ShipTypeId;
	public int Length;
	public boolean IsVertical;
	public int StartCol;
	public int StartRow;


	public ShipDataObject (int id, int boardId, int shipTypeId, int length, boolean isVertical, int startCol, int startRow) {
		this.Id = id;
		this.BoardId = boardId;
		this.ShipTypeId = shipTypeId;
		this.Length = length;
		this.IsVertical = isVertical;
		this.StartCol = startCol;
		this.StartRow = startRow;
	}	
}