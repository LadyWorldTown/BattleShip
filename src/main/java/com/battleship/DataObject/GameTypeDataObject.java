package com.battleship.DataObject;

public class GameTypeDataObject {

	public int Id;
	public String Name;
	public int boardSizeColumns;
	public int boardSizeRows;

	public GameTypeDataObject (int id, String name, int boardSizeColumns, int boardSizeRows) {
		this.Id = id;
		this.Name = name;
		this.boardSizeColumns = boardSizeColumns;
		this.boardSizeRows = boardSizeRows;
	}

}