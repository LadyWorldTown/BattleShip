package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.PlayerDataObject;
import com.battleship.restService.Request.RegisterPlayerRequest;

public class PlayerDomainObject {

	//This is used only for passing messages back to the Controller.
	public ArrayList<String> errorMessages;
	//This is used only for passing messages back to the Controller.
	public ArrayList<String> messages;

		
	public int Id;
	public String UserName;
	public String Password;


	public PlayerDomainObject(PlayerDataObject data) {
		this.Id = data.Id;
		this.UserName = data.UserName;
		this.Password = data.Password;
	}
	
	public static ArrayList<PlayerDomainObject> MapList(ArrayList<PlayerDataObject> dataList) {
		ArrayList<PlayerDomainObject> domainObjectList = new ArrayList<PlayerDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			PlayerDomainObject domain = new PlayerDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}

	public PlayerDomainObject(RegisterPlayerRequest request) {
		this.UserName = request.getUsername();
		this.Password = request.getPassword();
	}

}