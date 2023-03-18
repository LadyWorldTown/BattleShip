package com.battleship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.battleship.DataAccess.BoardDataAccess;
import com.battleship.DataAccess.GameDataAccess;
import com.battleship.DataAccess.GameTypeDataAccess;
import com.battleship.DataAccess.GameTypeShipTypeDataAccess;
import com.battleship.DataAccess.PlayerDataAccess;
import com.battleship.DataAccess.ShipDataAccess;
import com.battleship.DataAccess.ShipTypeDataAccess;
import com.battleship.DataAccess.SpaceDataAccess;


@SpringBootApplication
public class Battleship {

	public static void main(String[] args) {
		SpringApplication.run(Battleship.class, args);

		GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
		GameTypeShipTypeDataAccess GameTypeShipTypeDataAccess = new GameTypeShipTypeDataAccess();
		ShipTypeDataAccess shipTypeDataAccess = new ShipTypeDataAccess();
		PlayerDataAccess playerDataAccess = new PlayerDataAccess();
		ShipDataAccess shipDataAccess = new ShipDataAccess();
		SpaceDataAccess spaceDataAccess = new SpaceDataAccess();
		BoardDataAccess boardDataAccess = new BoardDataAccess();
		GameDataAccess gameDataAccess = new GameDataAccess();

		
	}

}
