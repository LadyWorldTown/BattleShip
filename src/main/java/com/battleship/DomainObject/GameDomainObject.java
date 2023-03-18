package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.GameDataObject;
import com.battleship.restService.Request.CreateGameRequest;

public class GameDomainObject {

	public int Id;
	public int CurrentTurnPlayer;
	public int GameTypeId;
	public int WinnerPlayer;
	public String GameStatus;  //Meaning?

	public int Player1Id;
	public PlayerDomainObject Player1;
	public int Player2Id;
	public PlayerDomainObject Player2;
	public int Board1Id;
	public BoardDomainObject Board1;
	public int Board2Id;
	public BoardDomainObject Board2;

	public GameDomainObject(GameDataObject data) {
		this.Id = data.Id;
		this.CurrentTurnPlayer = data.CurrentTurnPlayer;
		this.GameTypeId = data.GameTypeId;
		this.WinnerPlayer = data.WinnerPlayer;
		this.GameStatus = data.GameStatus;

		this.Player1Id = data.Player1Id;
		this.Player2Id = data.Player2Id;
		this.Board1Id = data.Board1Id;
		this.Board2Id = data.Board2Id;
	}


	public static ArrayList<GameDomainObject> MapList(ArrayList<GameDataObject> dataList) {
		ArrayList<GameDomainObject> domainObjectList = new ArrayList<GameDomainObject>();
		
		for (int i=0; i<dataList.size(); i++) {
			GameDomainObject domain = new GameDomainObject(dataList.get(i));
			domainObjectList.add(domain);
		}

		return domainObjectList;
	}

	public GameDomainObject(CreateGameRequest data) {
		this.GameTypeId = data.getGameTypeId();
		this.Player1Id = data.getPlayer1Id();
		this.Player2Id = data.getPlayer2Id();
	}
	

}
