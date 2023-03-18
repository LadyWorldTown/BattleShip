package com.battleship.restService.Response;
import java.util.ArrayList;
import com.battleship.DomainObject.GameTypeDomainObject;
import com.battleship.DomainObject.ShipTypeDomainObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameTypeResponse {

	private final int gameTypeId;
	private final String name;
	private final int boardSizeColumns;
	private final int boardSizeRows;
	private final ArrayList<ShipType> shipTypes;

	@JsonCreator
	public GameTypeResponse(int gameTypeId, String name, int boardSizeColumns, int boardSizeRows, ArrayList<ShipType> shipTypes) {
		this.gameTypeId = gameTypeId;
		this.name = name;
		this.boardSizeColumns = boardSizeColumns;
		this.boardSizeRows = boardSizeRows;
		this.shipTypes = shipTypes;
	}

	public GameTypeResponse(GameTypeDomainObject domainObject) {
		this.gameTypeId = domainObject.Id;
		this.name = domainObject.Name;
		this.boardSizeColumns = domainObject.boardSizeColumns;
		this.boardSizeRows = domainObject.boardSizeRows;
		this.shipTypes = ShipTypeDomainObject.MapToRequest(domainObject.ships);
	}

	public static ArrayList<GameTypeResponse> MapList(ArrayList<GameTypeDomainObject> domainList) {
		ArrayList<GameTypeResponse> responseList = new ArrayList<GameTypeResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			GameTypeResponse response = new GameTypeResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	@JsonProperty("gametypeid")
	public int getGameTypeId() {
		return gameTypeId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("boardsizecolumns")
	public int getBoardSizeColumns() {
		return boardSizeColumns;
	}

	@JsonProperty("boardsizerows")
	public int getBoardSizeRows() {
		return boardSizeRows;
	}

	@JsonProperty("shiptypes")
	public ArrayList<ShipType> getShipTypes() {
		return shipTypes;
	}

	
	public static class ShipType {
		private final int shipTypeId;
		private final String name;
		private final int length;

		@JsonCreator
		public ShipType(int shipTypeId, String name, int length) {
			this.shipTypeId = shipTypeId;
			this.name = name;
			this.length = length;
		}

		@JsonProperty("shiptypeid")
		public int getShipTypeId() {
			return shipTypeId;
		}

		@JsonProperty("name")
		public String getName() {
			return name;
		}

		@JsonProperty("length")
		public int getLength() {
			return length;
		}
	}

}