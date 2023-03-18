package com.battleship.DataObject;

public class SpaceDataObject {

	public int Id;
	public int BoardId;
	public int Column;
	public int Row;
	public int ShipId;
	public String Status;  //open, hit, miss

	public SpaceDataObject (int id, int boardId, int column, int row, int shipId, String status) {
		this.Id = id;
		this.BoardId = boardId;
		this.Column = column;
		this.Row = row;
		this.ShipId = shipId;
		this.Status = status;
	}	

}