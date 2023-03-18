package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.SpaceDataObject;
import com.battleship.restService.Response.GameResponse;

public class SpaceDomainObject {

	public int Id;
	public int BoardId;
	public int Column;
	public int Row;
	public int ShipId;
	public String Status;  //open, hit, miss


	public SpaceDomainObject(SpaceDataObject data) {
		this.Id = data.Id;
		this.BoardId = data.BoardId;
		this.Column = data.Column;
		this.Row = data.Row;
		this.ShipId = data.ShipId;
		this.Status = data.Status;
	}
	
	public static ArrayList<SpaceDomainObject> MapList(ArrayList<SpaceDataObject> dataList) {
		ArrayList<SpaceDomainObject> domainObjectList = new ArrayList<SpaceDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			SpaceDomainObject domain = new SpaceDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}
	

	public static GameResponse.Board.Space MapToResponse(SpaceDomainObject domain){
		GameResponse.Board.Space response = new GameResponse.Board.Space(domain.Id, domain.Column, domain.Row, domain.ShipId, domain.Status);
		return response;
	}


	public static ArrayList<GameResponse.Board.Space> MapToResponseList(ArrayList<SpaceDomainObject> domain){
		if (domain == null)
			return null;

		ArrayList<GameResponse.Board.Space> requestList = new ArrayList<GameResponse.Board.Space>();
		for (int i=0; i< domain.size(); i++) {
			requestList.add(MapToResponse(domain.get(i)));
		}	
		return requestList;
	}

}