package com.battleship.DataObject;

public class PlayerDataObject {

	public int Id;
	public String UserName;
	public String Password;

	public PlayerDataObject (int id, String userName, String password) {
		this.Id = id;
		this.UserName = userName;
		this.Password = password;
	}

}