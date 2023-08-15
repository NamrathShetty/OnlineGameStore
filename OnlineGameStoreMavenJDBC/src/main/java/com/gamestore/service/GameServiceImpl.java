package com.gamestore.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.GameDaoImpl;
import com.gamestore.dao.IGameDao;
import com.gamestore.exception.GameNotFoundException;
import com.gamestore.model.Game;
import com.gamestore.model.User;

public class GameServiceImpl implements IGameService {

	IGameDao gameDao=new GameDaoImpl();
	
	@Override
	public void addGame(Game game) {
		gameDao.addGame(game);
	}

	@Override
	public int updatePrice(int gameId, double price) {
		int result=gameDao.updatePrice(gameId,price);
		if(result==0)
			throw new GameNotFoundException("There is no game with ID: "+gameId);
		return result;
	}

	@Override
	public int updateRating(int gameId, int rating) {
		int result=gameDao.updateRating(gameId,rating);
		if(result==0)
			throw new GameNotFoundException("There is no game with ID: "+gameId);
		return result;
	}
	

	@Override
	public void deleteGame(int gameId) {
		gameDao.deleteGame(gameId);

	}

	@Override
	public Game getById(int gameId) {
		Game game=gameDao.findById(gameId);
		if(game==null)
			return null;
		return game;
	}

	@Override
	public List<Game> getAll() {
		List<Game> gameList=gameDao.findAll();
		return gameList;
	}

	@Override
	public List<Game> getByDeveloper(String developer) throws GameNotFoundException {
		List<Game> gameList=gameDao.findByDeveloper(developer);
		if(gameList.isEmpty())
				throw new GameNotFoundException("There is no game made by"+developer);
		return gameList.stream().sorted((g1,g2)->g1.getGameName().compareTo(g2.getGameName())).collect(Collectors.toList());
		
	}

	@Override
	public List<Game> getByGenre(String genre) throws GameNotFoundException {
		List<Game> gameList=gameDao.findByGenre(genre);
		if(gameList.isEmpty())
				throw new GameNotFoundException("There is no game in "+genre);
		return gameList.stream().sorted((g1,g2)->g1.getGameName().compareTo(g2.getGameName())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByDeveloperAndGenre(String developer, String genre) throws GameNotFoundException {
		List<Game> gameList=gameDao.findByDeveloperAndGenre(developer,genre);
		if(gameList.isEmpty())
				throw new GameNotFoundException("There is no game made by"+developer+" and of "+genre);
		return gameList.stream().sorted((g1,g2)->g1.getGameName().compareTo(g2.getGameName())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByPrice(double price) throws GameNotFoundException {
		List<Game> gameList=gameDao.findByPrice(price);
		if(gameList.isEmpty())
				throw new GameNotFoundException("There is no game with price less than"+price);
		return gameList.stream().sorted((g1,g2)->g1.getGameName().compareTo(g2.getGameName())).collect(Collectors.toList());
	}

	@Override
	public void buyGame(int userId, int gameId) throws GameNotFoundException {
		gameDao.buyGame(userId, gameId);
		
	}

	@Override
	public List<String> findAllGamesPurchased(int userId) {
		List<String> gameList=gameDao.findAllGamesPurchased(userId);
		if(gameList.isEmpty())
			System.out.println("You have not purchased any game");
		return gameList;

	}

	@Override
	public int validateUser(String username, String password) {
		return gameDao.validateUser(username, password);
		
	}

	@Override
	public void registerUser(User user) {
		gameDao.registerUser(user);
		
	}

}
