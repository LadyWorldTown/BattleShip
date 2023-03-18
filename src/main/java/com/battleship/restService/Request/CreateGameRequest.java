package com.battleship.restService.Request;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateGameRequest {

	private final int player1id;
	private final int player2id;
	private final int gametypeid;

	@JsonCreator
	public CreateGameRequest(@JsonProperty("player1id") int player1Id, @JsonProperty("player2id") int player2Id, @JsonProperty("gametypeid") int gameTypeId) {
		this.player1id = player1Id;
		this.player2id = player2Id;
		this.gametypeid = gameTypeId;
	}

	public int getPlayer1Id() {
		return player1id;
	}

	public int getPlayer2Id() {
		return player2id;
	}

	public int getGameTypeId() {
		return gametypeid;
	}

}