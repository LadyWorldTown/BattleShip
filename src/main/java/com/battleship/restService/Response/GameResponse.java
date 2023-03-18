package com.battleship.restService.Response;

import java.util.ArrayList;
import com.battleship.DomainObject.BoardDomainObject;
import com.battleship.DomainObject.GameDomainObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class GameResponse {

	private final int gameId;
	private final int player1Id;
	private final int player2Id;
	private final int gameTypeId;
	private final String status;
	private final int winner;
	private final Board player1Board;
	private final Board player2Board;
	private final int playerTurn;

	@JsonCreator
	public GameResponse(int gameId, int player1Id, int player2Id, int gameTypeId, String status, int winner, Board player1Board, Board player2Board, int playerTurn) {
		this.gameId = gameId;
		this.player1Id = player1Id;
		this.player2Id = player2Id;
		this.gameTypeId = gameTypeId;
		this.status = status;
		this.winner = winner;
		this.player1Board = player1Board;
		this.player2Board = player2Board;
		this.playerTurn = playerTurn;
	}

	public GameResponse(GameDomainObject domainObject) {
		this.gameId = domainObject.Id;
		this.player1Id = domainObject.Player1Id;
		this.player2Id = domainObject.Player2Id;
		this.gameTypeId = domainObject.GameTypeId;
		this.status = domainObject.GameStatus;
		this.winner = domainObject.WinnerPlayer;
		this.player1Board = BoardDomainObject.MapToRequest(domainObject.Board1);
		this.player2Board = BoardDomainObject.MapToRequest(domainObject.Board2);
		this.playerTurn = domainObject.CurrentTurnPlayer;
		
	}

	public static ArrayList<GameResponse> MapList(ArrayList<GameDomainObject> domainList) {
		ArrayList<GameResponse> responseList = new ArrayList<GameResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			GameResponse response = new GameResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	@JsonProperty("gameid")
	public int getGameId() {
		return gameId;
	}

	@JsonProperty("player1id")
	public int getPlayer1Id() {
		return player1Id;
	}

	@JsonProperty("player2id")
	public int getPlayer2Id() {
		return player2Id;
	}

	@JsonProperty("gametypeid")
	public int getGameTypeId() {
		return gameTypeId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("winner")
	public int getWinner() {
		return winner;
	}

	@JsonProperty("player1board")
	public Board getPlayer1Board() {
		return player1Board;
	}
	
	@JsonProperty("player2board")
	public Board getPlayer2Board() {
		return player2Board;
	}
	
	@JsonProperty("playerturn")
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public static class Board {
		private final ArrayList<Space> spaces;
		private final ArrayList<ShipLocation> ships;

		@JsonCreator
		public Board(ArrayList<Space> spaces, ArrayList<ShipLocation> ships) {
			this.spaces = spaces;
			this.ships = ships;
		}

		public ArrayList<Space> getSpaces() {
			return spaces;
		}

		public ArrayList<ShipLocation> getShips() {
			return ships;
		}

		
		public static class Space {
			private final int spaceId;
			private final int column;
			private final int row;
			private final int shipId;
			private final String status;
	
			@JsonCreator
			public Space(int spaceId, int column, int row, int shipId, String status) {
				this.spaceId = spaceId;
				this.column = column;
				this.row = row;
				this.shipId = shipId;
				this.status = status;
			}
	
			@JsonProperty("spaceid")
			public int getSpaceId() {
				return spaceId;
			}

			@JsonProperty("column")
			public int getColumn() {
				return column;
			}
	
			@JsonProperty("row")
			public int getRow() {
				return row;
			}

			@JsonProperty("shipid")
			public int getShipId() {
				return shipId;
			}

			@JsonProperty("status")
			public String getStatus() {
				return status;
			}
		}

		public static class ShipLocation {
			private final int shipTypeId;
			private final int startCol;
			private final int startRow;
			private final boolean isVertical;
	
			@JsonCreator
			public ShipLocation(int shipTypeId, int startCol, int startRow, boolean isVertical) {
				this.shipTypeId = shipTypeId;
				this.startCol = startCol;
				this.startRow = startRow;
				this.isVertical = isVertical;
			}
	
			@JsonProperty("shiptypeid")
			public int getShipTypeId() {
				return shipTypeId;
			}
	
			@JsonProperty("startcol")
			public int getStartCol() {
				return startCol;
			}
	
			@JsonProperty("startrow")
			public int getStartRow() {
				return startRow;
			}

			@JsonProperty("isvertical")
			public boolean getIsVertical() {
				return isVertical;
			}
				
	
		}
	}

}