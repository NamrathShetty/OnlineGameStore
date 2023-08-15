package com.gamestore.model;

public class Game {

	private String gameName;
	private Integer gameId;
	private String gameGenre;
	private double gamePrice;
	private String gameDeveloper;
	private int gameRating;
	public Game() {
		super();
	}
	public Game(String gameName, String gameGenre, double gamePrice, String gameDeveloper, int gameRating) {
		super();
		this.gameName = gameName;
		this.gameGenre = gameGenre;
		this.gamePrice = gamePrice;
		this.gameDeveloper = gameDeveloper;
		this.gameRating = gameRating;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public String getGameGenre() {
		return gameGenre;
	}
	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}
	public double getGamePrice() {
		return gamePrice;
	}
	public void setGamePrice(double gamePrice) {
		this.gamePrice = gamePrice;
	}
	public String getGameDeveloper() {
		return gameDeveloper;
	}
	public void setGameDeveloper(String gameDeveloper) {
		this.gameDeveloper = gameDeveloper;
	}
	public int getGameRating() {
		return gameRating;
	}
	public void setGameRating(int gameRating) {
		this.gameRating = gameRating;
	}
	@Override
	public String toString() {
		return "Game [gameId=" + gameId + " ,gameName=" + gameName +", gameGenre=" + gameGenre + ", gamePrice="
				+ gamePrice + ", gameDeveloper=" + gameDeveloper + ", gameRating=" + gameRating + "]";
	}

	
}
