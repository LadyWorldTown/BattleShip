package com.battleship.restService.Response;


import java.util.ArrayList;

import com.battleship.DomainObject.PlayerDomainObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PlayerResponse {

	private final int playerId;
	private final String username;

	@JsonCreator
	public PlayerResponse(int playerId, String username) {
		this.playerId = playerId;
		this.username = username;
	}

	public PlayerResponse(PlayerDomainObject domainObject) {
		this.playerId = domainObject.Id;
		this.username = domainObject.UserName;
	}

	public static ArrayList<PlayerResponse> MapList(ArrayList<PlayerDomainObject> domainList) {
		ArrayList<PlayerResponse> responseList = new ArrayList<PlayerResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			PlayerResponse response = new PlayerResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	@JsonProperty("playerid")
	public int getPlayerId() {
		return playerId;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
}