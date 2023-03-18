package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.GameTypeDataObject;

public class GameTypeDomainObject {

	//This is used only for passing messages back to the Controller.
	public ArrayList<String> errorMessages;
	//This is used only for passing messages back to the Controller.
	public ArrayList<String> messages;
	
	public int Id;
	public String Name;
	public int boardSizeColumns;
	public int boardSizeRows;

	public ArrayList<ShipTypeDomainObject> ships;

	public GameTypeDomainObject(GameTypeDataObject data) {
		this.Id = data.Id;
		this.Name = data.Name;
		this.boardSizeColumns = data.boardSizeColumns;
		this.boardSizeRows = data.boardSizeRows;
	}
	
	public static ArrayList<GameTypeDomainObject> MapList(ArrayList<GameTypeDataObject> dataList) {
		ArrayList<GameTypeDomainObject> domainObjectList = new ArrayList<GameTypeDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			GameTypeDomainObject domain = new GameTypeDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}
}