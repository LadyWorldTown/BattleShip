package com.battleship.DataAccess;

import java.util.ArrayList;

import org.apache.catalina.User;

import com.battleship.DataObject.PlayerDataObject;
import com.battleship.DomainObject.PlayerDomainObject;

public class PlayerDataAccess {

	private static ArrayList<PlayerDataObject> players;

	public PlayerDataAccess() {
		initialize();
	}

	private void initialize() {
		players = new ArrayList<PlayerDataObject>();
	
		//Default Data
		//R. Florin
		players.add(new PlayerDataObject(getNextId(), "rflorin", "pass1"));
		//K. Findley
		players.add(new PlayerDataObject(getNextId(), "kfindley", "pass2"));
		
	}

	private static int getNextId() {
		return players.size()+1;
	}

	public static ArrayList<PlayerDataObject> getAllPlayers() {
		return players;
	}

	public static PlayerDataObject getPlayerById(int Id) {
		
		for (int i=0; i < players.size(); i++) {
			if (players.get(i).Id == Id) {
				return players.get(i);
			}
		}
		
		return null;
	}


	public static PlayerDataObject createPlayer(PlayerDataObject data) {
		//To Be Written - Tierra Anthony
		PlayerDataObject newPlayers = new PlayerDataObject(getNextId(), data.UserName, data.Password );
		
		players.add(newPlayers);
		return newPlayers;
		
	}
}