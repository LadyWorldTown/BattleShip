package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.BoardDataObject;

public class BoardDataAccess {

	private static ArrayList<BoardDataObject> boards;

	public BoardDataAccess() {
		initialize();
	}

	private void initialize() {
		boards = new ArrayList<BoardDataObject>();
	
		//Default Data
		boards.add( new BoardDataObject(getNextId()));
		boards.add( new BoardDataObject(getNextId()));
	}

	private static int getNextId() {
		return boards.size()+1;
	}


	public static BoardDataObject getBoardById(int Id) {
		
		for (int i=0; i < boards.size(); i++) {
			if (boards.get(i).Id == Id) {
				return boards.get(i);
			}
		}
		
		return null;
	}

	public static BoardDataObject createBoard(BoardDataObject data) {
		//To Be Written
		return null;
	}

}