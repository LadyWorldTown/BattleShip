package com.battleship.DomainObject;

import java.util.ArrayList;

import com.battleship.DataObject.ShipDataObject;
import com.battleship.restService.Request.SetShipsRequest;
import com.battleship.restService.Response.GameResponse;

public class ShipDomainObject {

	public int Id;
	public int BoardId;
	public int ShipTypeId;
	public int Length;
	public boolean IsVertical;
	public int StartCol;
	public int StartRow;

	public ShipDomainObject(ShipDataObject data) {
		this.Id = data.Id;
		this.BoardId = data.BoardId;
		this.ShipTypeId = data.ShipTypeId;
		this.Length = data.Length;
		this.IsVertical = data.IsVertical;
		this.StartCol = data.StartCol;
		this.StartRow = data.StartRow;
		
	}
	
	public static ArrayList<ShipDomainObject> MapFromDataList(ArrayList<ShipDataObject> dataList) {
		ArrayList<ShipDomainObject> domainObjectList = new ArrayList<ShipDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			ShipDomainObject domain = new ShipDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}
	

	public ShipDomainObject(SetShipsRequest.ShipLocation data) {

		this.ShipTypeId = data.getShipTypeId();
		this.IsVertical = data.getIsVertical();
		this.StartCol = data.getStartCol();
		this.StartRow = data.getStartRow();
		
	}
	
	public static ArrayList<ShipDomainObject> MapFromRequestList(ArrayList<SetShipsRequest.ShipLocation> requestList) {
		ArrayList<ShipDomainObject> domainObjectList = new ArrayList<ShipDomainObject>();
		
		for (int i=0; i<requestList.size(); i++) {
			ShipDomainObject domain = new ShipDomainObject(requestList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}

	public static GameResponse.Board.ShipLocation MapToResponse(ShipDomainObject domain){
		GameResponse.Board.ShipLocation response = new GameResponse.Board.ShipLocation(domain.ShipTypeId, domain.StartCol, domain.StartRow, domain.IsVertical);
		return response;
	}


	public static ArrayList<GameResponse.Board.ShipLocation> MapToResponseList(ArrayList<ShipDomainObject> domain){
		ArrayList<GameResponse.Board.ShipLocation> requestList = new ArrayList<GameResponse.Board.ShipLocation>();
		for (int i=0; i< domain.size(); i++) {
			requestList.add(MapToResponse(domain.get(i)));
		}	
		return requestList;
	}


}