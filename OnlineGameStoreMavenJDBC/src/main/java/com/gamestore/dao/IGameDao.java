package com.gamestore.dao;

import java.util.List;


import com.gamestore.exception.GameNotFoundException;
import com.gamestore.model.Game;
import com.gamestore.model.User;

public interface IGameDao {

	void addGame(Game game);
	int updatePrice(int gameId,double price);
	int updateRating(int gameId, int rating);
	void deleteGame(int gameId);
	Game findById(int gameId);
	
	List<Game> findAll();
	List<Game> findByDeveloper(String developer)throws GameNotFoundException;
	List<Game> findByGenre(String genre)throws GameNotFoundException;
	List<Game> findByDeveloperAndGenre(String developer, String genre)throws GameNotFoundException;
	List<Game> findByPrice(double price)throws GameNotFoundException;
	void buyGame(int userId,int gameId)throws GameNotFoundException;
	List<String> findAllGamesPurchased(int userId);
	int validateUser(String username,String password);
	void registerUser(User user);
}
