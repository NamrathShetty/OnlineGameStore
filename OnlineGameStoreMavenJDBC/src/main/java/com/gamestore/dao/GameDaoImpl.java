package com.gamestore.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamestore.exception.GameNotFoundException;
import com.gamestore.model.Game;
import com.gamestore.model.User;
import com.gamestore.util.DBConnection;
import com.gamestore.util.Queries;

public class GameDaoImpl implements IGameDao {

	@Override
	public void addGame(Game game) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setString(1, game.getGameName());
			statement.setDouble(2, game.getGamePrice());
			statement.setString(3, game.getGameGenre());
			statement.setString(4, game.getGameDeveloper());
			statement.setInt(5, game.getGameRating());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updatePrice(int gameId, double price) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEPRICEQUERY);) {
			statement.setDouble(1, price);
			statement.setInt(2, gameId);
			statement.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int updateRating(int gameId, int rating) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATERATINGQUERY);) {
			statement.setInt(1, rating);
			statement.setInt(2, gameId);
			statement.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void deleteGame(int gameId) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
			statement.setInt(1, gameId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Game> findAll() {
		List<Game> gameList = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTQUERY);) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Game gameDao = new Game();
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
				gameList.add(gameDao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public Game findById(int gameId) {
		Game gameDao = new Game();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID);) {
			statement.setInt(1, gameId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameDao;
	}

	@Override
	public List<Game> findByDeveloper(String developer) throws GameNotFoundException {
		List<Game> gameList = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYDEVELOPER);) {
			statement.setString(1, "%" + developer + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Game gameDao = new Game();
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
				gameList.add(gameDao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<Game> findByGenre(String genre) throws GameNotFoundException {
		List<Game> gameList = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYGENRE);) {
			statement.setString(1, "%" + genre + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Game gameDao = new Game();
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
				gameList.add(gameDao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<Game> findByDeveloperAndGenre(String developer, String genre) throws GameNotFoundException {
		List<Game> gameList = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYDEVELOPERANDGENRE);) {
			statement.setString(1, "%" + developer + "%");
			statement.setString(2, "%" + genre + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Game gameDao = new Game();
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
				gameList.add(gameDao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<Game> findByPrice(double price) throws GameNotFoundException {
		List<Game> gameList = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYPRICE);) {
			statement.setDouble(1, price);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Game gameDao = new Game();
				gameDao.setGameName(resultSet.getString("gameName"));
				gameDao.setGameId(resultSet.getInt("gameId"));
				gameDao.setGamePrice(resultSet.getDouble("gamePrice"));
				gameDao.setGameGenre(resultSet.getString("gameGenre"));
				gameDao.setGameDeveloper(resultSet.getString("gameDeveloper"));
				gameDao.setGameRating(resultSet.getInt("gameRating"));
				gameList.add(gameDao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public void buyGame(int userId, int gameId) throws GameNotFoundException {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement gameStatement = connection.prepareStatement(Queries.QUERYBYID);			
				PreparedStatement userStatement = connection.prepareStatement(Queries.SELECTUSERBYID);
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTPURCHASEQUERY);
			PreparedStatement updateStatement = connection.prepareStatement(Queries.UPDATEUSERQUERY);) {
			gameStatement.setInt(1, gameId);
			userStatement.setInt(1, userId);
			ResultSet gameResult=gameStatement.executeQuery();
			ResultSet userResult=userStatement.executeQuery();
			while(gameResult.next()) {
				while(userResult.next()) {
			double gamePrice=gameResult.getDouble("gamePrice");
			double amount=userResult.getDouble("amount");
			if(amount>=gamePrice) {
			statement.setInt(1, userId);
			statement.setInt(2, gameId);
			updateStatement.setDouble(1, (amount-gamePrice));
			updateStatement.setInt(2, userId);
			updateStatement.execute();
			statement.execute();
			}else {
				System.out.println("You do not have sufficient amount to by this game");
			}}}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int validateUser(String username, String password) {
		int userId = 0;
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTALLUSERQUERY);) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("userName").equals(username)
						&& resultSet.getString("password").equals(password)) {
					userId = resultSet.getInt("userId");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public List<String> findAllGamesPurchased(int userId) {
		List<String> gameList = new ArrayList<String>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTUSERPURCHASEDQUERY);
				PreparedStatement userStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int gameId = resultSet.getInt("gameId");
				userStatement.setInt(1, gameId);
				ResultSet userResultSet = userStatement.executeQuery();
				while (userResultSet.next()) {
					gameList.add(userResultSet.getString("gameName"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public void registerUser(User user) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTUSERQUERY);) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setDouble(3, user.getAmount());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
