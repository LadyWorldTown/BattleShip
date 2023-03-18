package com.battleship.restService.Request;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterPlayerRequest {

	private final String username;
	private final String password;


	@JsonCreator
	public RegisterPlayerRequest(@JsonProperty("username") String username, @JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}