package com.battleship.restService.Request;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TakeTurnRequest {

	private final int playerid;
	private final int gameid;
	private final int column;
	private final int row;

	@JsonCreator
	public TakeTurnRequest(@JsonProperty("playerid")int playerId, @JsonProperty("gameid")int gameId, @JsonProperty("column")int column, @JsonProperty("row")int row) {
		this.playerid = playerId;
		this.gameid = gameId;
		this.column = column;
		this.row = row;
		
	}


	public int getPlayerId() {
		return playerid;
	}

	public int getGameId() {
		return gameid;
	}

	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
}