package com.battleship.DataAccess;

import java.util.ArrayList;

import com.battleship.DataObject.SpaceDataObject;

public class SpaceDataAccess {

	private static ArrayList<SpaceDataObject> spaces;


	public SpaceDataAccess() {
		initialize();
	}

	private void initialize() {
		spaces = new ArrayList<SpaceDataObject>();
	
		//Default Data

		//Board 1 Spaces
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 1, 3, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 1, 3, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 1, 3, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 2, 2, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 3, 2, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 4, 2, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 5, 2, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 6, 4, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 6, 4, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 6, 4, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 8, 5, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 8, 5, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 9, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 1, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 2, 10, 1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 3, 10, 1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 4, 10, 1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 5, 10, 1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 6, 10, 1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 7, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 8, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 0, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 1, 10, 10, -1, "open"));

		//Board 2 Spaces
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 1, 7, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 1, 7, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 1, 7, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 1, 7, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 1, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 1, 9, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 2, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 2, 9, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 3, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 3, 9, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 4, 6, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 4, 6, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 4, 6, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 4, 6, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 4, 6, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 4, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 5, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 6, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 7, 8, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 7, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 8, 8, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 8, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 9, 8, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 9, 10, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 9, 10, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 9, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 9, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 1, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 2, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 3, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 4, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 5, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 6, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 7, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 8, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 0, 10, -1, "open"));
		spaces.add(new SpaceDataObject (getNextId(), 2, 10, 10, -1, "open"));
	}

	private static int getNextId() {
		return spaces.size()+1;
	}

	private static SpaceDataObject getSpaceById(int Id) {
		for (int i=0; i < spaces.size(); i++) {
			if (spaces.get(i).Id == Id) {
				return spaces.get(i);
			}
		}
		return null;
	}

	public static ArrayList<SpaceDataObject> getSpacesForBoardId(int boardId) {
		ArrayList<SpaceDataObject> spacesForBoard = new ArrayList<SpaceDataObject>();
		for (int i=0; i < spaces.size(); i++) {
			if (spaces.get(i).BoardId == boardId) {
				spacesForBoard.add(spaces.get(i));
			}
		}
		return spacesForBoard;
	}

	public static SpaceDataObject createSpace(SpaceDataObject data) {
		//To Be Written
		return null;
	}

}