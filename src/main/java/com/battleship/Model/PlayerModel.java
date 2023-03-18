package com.battleship.Model;
import java.util.ArrayList;
import java.util.regex.*;
import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.DataObject.PlayerDataObject;
import com.battleship.DomainObject.PlayerDomainObject;
import com.battleship.restService.Message;


public class PlayerModel {
	
	public static PlayerDomainObject GetPlayerById(Message message, int id) {
		PlayerDataObject playerData = PlayerDataAccess.getPlayerById(id);
		PlayerDomainObject playerDomain = new PlayerDomainObject(playerData);
		return playerDomain;
	}

	public static ArrayList<PlayerDomainObject> GetAllPlayers(Message messasge) {
		ArrayList<PlayerDataObject> playerDataList = PlayerDataAccess.getAllPlayers();
		ArrayList<PlayerDomainObject> playerDomainList = PlayerDomainObject.MapList(playerDataList);
		return playerDomainList;
	}

	public static PlayerDomainObject RegisterPlayer(Message message, PlayerDomainObject domainPlayerToCreate) {
		// validate the uniqnes of the username and password
		//To Be Written - Tierra Anthony
		String wrongRegex = ".*[~!@#$%^&*()_+={}\\\\[\\\\]:;,.<>/?-].*";
		final String userUniq = ("Username is already taken.  Please select another.");
		final String  invalidUseN = ("Username must contain 8-25 characters - including only English letters and numbers.");
		final String invalidPass = ("Password must contain 8-25 characters - including only English letters and numbers.");
		boolean userNotUn = false, passValid = false, userNameValid = false;

		ArrayList<PlayerDataObject> playerlist = PlayerDataAccess.getAllPlayers();

		for (int i = 0; i < playerlist.size(); i++){
			String playerDataList = playerlist.get(i).UserName;
			if (domainPlayerToCreate.UserName.equals(playerDataList)){
					 userNotUn = true;
				message.addErrorMessage(userUniq);
				message.getErrorMessage();
			}	
		}
		
		if (domainPlayerToCreate.UserName.length() <= 25 && domainPlayerToCreate.UserName.length() >= 8 && domainPlayerToCreate.UserName.matches(wrongRegex) != true) {
				userNameValid = true;
				
		}else{
		//else //wrongRegex and too short or long
			 	message.addErrorMessage(invalidUseN);
				
				message.getErrorMessage();
	}
		if (domainPlayerToCreate.Password.length() <= 25 && domainPlayerToCreate.Password.length() >= 8 && domainPlayerToCreate.Password.matches(wrongRegex)!= true) {
				passValid = true;
				
		}else{ //wrongRegex and too short or long
				message.addErrorMessage(invalidPass);
				message.getErrorMessage();
		}
			if (userNotUn == false && userNameValid && passValid){
				PlayerDataObject playerCreated = PlayerDataAccess.createPlayer(new PlayerDataObject(domainPlayerToCreate.Id ,domainPlayerToCreate.UserName, domainPlayerToCreate.Password));
				PlayerDomainObject newPlayer = new PlayerDomainObject(playerCreated);

				return newPlayer;
			}else {
				return null;
		}
	}
}