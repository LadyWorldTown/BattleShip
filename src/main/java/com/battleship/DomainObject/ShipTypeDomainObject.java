package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.ShipTypeDataObject;
import com.battleship.restService.Response.GameTypeResponse;

public class ShipTypeDomainObject {

	public int Id;
	public String ShipName;
	public int Length;

	public ShipTypeDomainObject(ShipTypeDataObject data) {
		this.Id = data.Id;
		this.ShipName = data.ShipName;
		this.Length = data.Length;
	}
	
	public static ArrayList<ShipTypeDomainObject> MapList(ArrayList<ShipTypeDataObject> dataList) {
		ArrayList<ShipTypeDomainObject> domainObjectList = new ArrayList<ShipTypeDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			ShipTypeDomainObject domain = new ShipTypeDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}

	public static GameTypeResponse.ShipType MapToRequest(ShipTypeDomainObject domain){
		GameTypeResponse.ShipType request = new GameTypeResponse.ShipType(domain.Id, domain.ShipName, domain.Length);
		return request;
	}

	public static ArrayList<GameTypeResponse.ShipType> MapToRequest(ArrayList<ShipTypeDomainObject> domainList){
		ArrayList<GameTypeResponse.ShipType> responseList = new ArrayList<GameTypeResponse.ShipType>();
		
		for (int i=0; i<domainList.size(); i++) {
			GameTypeResponse.ShipType responseItem = MapToRequest(domainList.get(i));
			responseList.add(responseItem);
		}

		return responseList;
	}
}