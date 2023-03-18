package com.battleship.DataObject;

public class GameDataObject {

	public int Id;
	public int CurrentTurnPlayer;
	public int GameTypeId;
	public int WinnerPlayer;
	public String GameStatus;  //Meaning?

	public int Player1Id;
	public int Player2Id;
	public int Board1Id;
	public int Board2Id;


	public GameDataObject (int id, int currentTurnPlayer, int gameTypeId, int winnerPlayer, String gameStatus, int player1Id, int player2Id, int board1Id, int board2Id) {
		this.Id = id;
		this.CurrentTurnPlayer = currentTurnPlayer;
		this.GameTypeId = gameTypeId;
		this.WinnerPlayer = winnerPlayer;
		this.GameStatus = gameStatus;
		this.Player1Id = player1Id;
		this.Player2Id = player2Id;
		this.Board1Id = board1Id;
		this.Board2Id = board2Id;
	}
}