package com.battleship.DomainObject;

import java.util.ArrayList;
import com.battleship.DataObject.BoardDataObject;
import com.battleship.restService.Response.GameResponse;

public class BoardDomainObject {

	public int Id;
	public ArrayList<ShipDomainObject> ships;
	public ArrayList<SpaceDomainObject> spaces;


	public BoardDomainObject(BoardDataObject data) {
		this.Id = data.Id;
		this.ships = new ArrayList<ShipDomainObject>();
		this.spaces = new ArrayList<SpaceDomainObject>();
	}
	
	public static GameResponse.Board MapToRequest(BoardDomainObject domain){
		if (domain == null)
			return null;
		ArrayList<GameResponse.Board.Space> spaces = SpaceDomainObject.MapToResponseList(domain.spaces); 
		ArrayList<GameResponse.Board.ShipLocation> ships = ShipDomainObject.MapToResponseList(domain.ships); 
		
		GameResponse.Board boardRequest = new GameResponse.Board(spaces, ships);

		return boardRequest;

	}


}