package com.gamestore.service;

import java.util.List;

import com.gamestore.exception.GameNotFoundException;
import com.gamestore.model.Game;
import com.gamestore.model.User;

public interface IGameService {

	void addGame(Game game);
	int updatePrice(int gameId,double price);
	int updateRating(int gameId, int rating);
	void deleteGame(int gameId);
	Game getById(int gameId);
	
	List<Game> getAll();
	List<Game> getByDeveloper(String developer)throws GameNotFoundException;
	List<Game> getByGenre(String genre)throws GameNotFoundException;
	List<Game> getByDeveloperAndGenre(String developer, String genre)throws GameNotFoundException;
	List<Game> getByPrice(double price)throws GameNotFoundException;
	void buyGame(int userId,int gameId)throws GameNotFoundException;
	List<String> findAllGamesPurchased(int userId);
	int validateUser(String username,String password);
	void registerUser(User user);
}
