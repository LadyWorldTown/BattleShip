package com.battleship.restService.Request;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//import com.battleship.restService.Response;

public class SetShipsRequest {

	private final int playerId;
	//private final int gameId;
	private final ArrayList<ShipLocation> shiplocations;

	@JsonCreator
	public SetShipsRequest(@JsonProperty("playerid") int playerId, @JsonProperty("shiplocations")ArrayList<ShipLocation> shipLocations) {
		this.playerId = playerId;
		this.shiplocations = shipLocations;
		
	}


	public int getPlayerId() {
		return playerId;
	}

	public ArrayList<ShipLocation> getShipLocations() {
		return shiplocations;
	}


	public static class ShipLocation {
		private final int shiptypeId;
		private final int startcol;
		private final int startrow;
		private final boolean isvertical;

		@JsonCreator
		public ShipLocation(@JsonProperty("shiptypeid") int shipTypeId, @JsonProperty("startcol")int startCol, @JsonProperty("startrow")int startRow, @JsonProperty("isvertical")boolean isVertical) {
			this.shiptypeId = shipTypeId;
			this.startcol = startCol;
			this.startrow = startRow;
			this.isvertical = isVertical;
		}

		public int getShipTypeId() {
			return shiptypeId;
		}

		public int getStartCol() {
			return startcol;
		}

		public int getStartRow() {
			return startrow;
		}
		
		public boolean getIsVertical() {
			return isvertical;
		}	

	}


}