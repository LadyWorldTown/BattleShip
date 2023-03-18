package com.battleship.Model;
import java.util.ArrayList;

import com.battleship.DataAccess.BoardDataAccess;
import com.battleship.DataAccess.ShipDataAccess;
import com.battleship.DataAccess.SpaceDataAccess;
import com.battleship.DataObject.BoardDataObject;
import com.battleship.DataObject.ShipDataObject;
import com.battleship.DataObject.SpaceDataObject;
import com.battleship.DomainObject.BoardDomainObject;
import com.battleship.DomainObject.ShipDomainObject;
import com.battleship.DomainObject.SpaceDomainObject;
import com.battleship.restService.Message;


public class BoardModel {
	
	public static BoardDomainObject GetBoardDetailsById(Message message, int boardId) {
		BoardDataObject boardData = BoardDataAccess.getBoardById(boardId);
		BoardDomainObject boardDomain = new BoardDomainObject(boardData);

		//Get Ships
		ArrayList<ShipDataObject> shipDataList = ShipDataAccess.getShipsForBoardId(boardId);
		ArrayList<ShipDomainObject> shipDomainList =  ShipDomainObject.MapFromDataList(shipDataList);
		boardDomain.ships = shipDomainList;

		//Get Space
		ArrayList<SpaceDataObject> spaceDataList = SpaceDataAccess.getSpacesForBoardId(boardId);
		ArrayList<SpaceDomainObject> spaceDomainList =  SpaceDomainObject.MapList(spaceDataList);
		boardDomain.spaces = spaceDomainList;

		return boardDomain;
	}



}