package com.gamestore.client;

import java.util.List;
import java.util.Scanner;

import com.gamestore.model.Game;
import com.gamestore.model.User;
import com.gamestore.service.GameServiceImpl;
import com.gamestore.service.IGameService;

public class Client {

	public static void main(String[] args) {

//		Game game =new Game("God of War","Action",3000,"Santa Monica Studio",5);
		IGameService gameService = new GameServiceImpl();
		Scanner scanner = new Scanner(System.in);

//		gameService.addGame(game);
//		gameService.updatePrice(1, 3600);
//		gameService.updateRating(1, 4);
//		gameService.getAll().forEach(System.out::println);

//		System.out.println(gameService.getById(1));

		String username;
		int userId;
		String password;
		double amount;
		System.out.println("Online Game Store Menu:");
		System.out.println("-----------------------------------");
		System.out.println("1. Admin");
		System.out.println("2. User");
		System.out.println("Enter your choice");
		int option = scanner.nextInt();
		if (option == 1) {
			int gameId;
			while (true) {
				System.out.println("Online Game Store Menu:");
				System.out.println("1. Display all Games");
				System.out.println("2. Search games by Developer");
				System.out.println("3. Search games by Category");
				System.out.println("4. Search games by Developer and Category");
				System.out.println("5. Search games less than price");
				System.out.println("6. Search game by ID");
				System.out.println("7. Add a new Game");
				System.out.println("8. Update Price of a Game");
				System.out.println("9. Update Ratings of a Game");
				System.out.println("10. Delete a Game");
				System.out.println("11. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				switch (choice) {
				case 1:
					List<Game> allGames = gameService.getAll();
					displayGames(allGames);
					break;
				case 2:
					System.out.print("Enter Game Developer: ");
					String developer = scanner.nextLine();
					List<Game> gamesByDeveloper = gameService.getByDeveloper(developer);
					displayGames(gamesByDeveloper);
					break;
				case 3:
					System.out.print("Enter Game Genre: ");
					String genre = scanner.next();
					List<Game> gamesByGenre = gameService.getByGenre(genre);
					displayGames(gamesByGenre);
					break;
				case 4:
					System.out.print("Enter Game Developer: ");
					String developer1 = scanner.nextLine();
					System.out.print("Enter Game Genre: ");
					String genre1 = scanner.nextLine();
					List<Game> gameByDevAndGenre = gameService.getByDeveloperAndGenre(developer1, genre1);
					displayGames(gameByDevAndGenre);
					break;
				case 5:
					System.out.print("Enter maximum price: ");
					double maxPrice = scanner.nextDouble();
					List<Game> gameByPrice = gameService.getByPrice(maxPrice);
					displayGames(gameByPrice);
					break;
				case 6:
					System.out.print("Enter Game ID: ");
					gameId = scanner.nextInt();
					Game gameById = gameService.getById(gameId);
					System.out.println(gameById);
					break;

//					Game game =new Game("God of War","Action",3000,"Santa Monica Studio",5);
				case 7:
					System.out.print("Enter Game Name: ");
					String gameName = scanner.nextLine();
					System.out.print("Enter Game Genre: ");
					String gameGenre = scanner.nextLine();
					System.out.print("Enter Game Price: ");
					double gamePrice = scanner.nextDouble();
					System.out.print("Enter Game Developer: ");
					scanner.nextLine();
					String gameDeveloper = scanner.nextLine();
					System.out.print("Enter Game Rating: ");
					int gameRating = scanner.nextInt();
					gameService.addGame(new Game(gameName, gameGenre, gamePrice, gameDeveloper, gameRating));
					System.out.println("Game has been added");
					break;
				case 8:
					System.out.print("Enter Game ID: ");
					gameId = scanner.nextInt();
					System.out.print("Enter new Price");
					double price = scanner.nextDouble();
					int result = gameService.updatePrice(gameId, price);
					if (result == 1)
						System.out.println("Price has been updated");
					break;
				case 9:
					System.out.print("Enter Game ID: ");
					gameId = scanner.nextInt();
					System.out.print("Enter new Rating: ");
					int rating = scanner.nextInt();
					int result1 = gameService.updateRating(gameId, rating);
					if (result1 == 1)
						System.out.println("Price has been updated");
					break;
				case 10:
					System.out.print("Enter game ID: ");
					gameId = scanner.nextInt();
					gameService.deleteGame(gameId);
					break;
				case 11:
					System.out.println("Exiting the application.");
					return;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			}

		} else if (option == 2) {
			System.out.println("User");
			System.out.println("1. Login");
			System.out.println("2. Register");
			int option1 = scanner.nextInt();
			if (option1 == 1) {
				System.out.println("Enter Username");
				scanner.nextLine();
				username = scanner.nextLine();
				System.out.println("Enter password");
//				scanner.nextLine();
				password = scanner.nextLine();
				userId = gameService.validateUser(username, password);
				if (userId == 0) {
					System.out.println("Invalid username and password");
					System.exit(0);
				} else {
					System.out.println("Welcome");
					while (true) {
						System.out.println("1. Display all Games");
						System.out.println("2. Search games by Developer");
						System.out.println("3. Search games by Category");
						System.out.println("4. Search games by Developer and Category");
						System.out.println("5. Search games less than price");
						System.out.println("6. Search game by ID");
						System.out.println("7. Buy a Game");
						System.out.println("8. Display all the Games Purchased");
						System.out.println("9. Exit");
						System.out.print("Enter your choice: ");
						int choice = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character

						switch (choice) {
						case 1:
							List<Game> allGames = gameService.getAll();
							displayGames(allGames);
							break;
						case 2:
							System.out.print("Enter Game Developer: ");
							String developer = scanner.nextLine();
							List<Game> gamesByDeveloper = gameService.getByDeveloper(developer);
							displayGames(gamesByDeveloper);
							break;
						case 3:
							System.out.print("Enter Game Genre: ");
							String genre = scanner.next();
							List<Game> gamesByGenre = gameService.getByGenre(genre);
							displayGames(gamesByGenre);
							break;
						case 4:
							System.out.print("Enter Game Developer: ");
							String developer1 = scanner.nextLine();
							System.out.print("Enter Game Genre: ");
							String genre1 = scanner.nextLine();
							List<Game> gameByDevAndGenre = gameService.getByDeveloperAndGenre(developer1, genre1);
							displayGames(gameByDevAndGenre);
							break;
						case 5:
							System.out.print("Enter maximum price: ");
							double maxPrice = scanner.nextDouble();
							List<Game> gameByPrice = gameService.getByPrice(maxPrice);
							displayGames(gameByPrice);
							break;
						case 6:
							System.out.print("Enter Game ID: ");
							int gameId = scanner.nextInt();
							Game gameById = gameService.getById(gameId);
							System.out.println(gameById);
							break;
						case 7:
							System.out.print("Enter Game ID: ");
							gameId = scanner.nextInt();
							gameService.buyGame(userId, gameId);
							break;
						case 8:
							List<String> purchasedGames = gameService.findAllGamesPurchased(userId);
							purchasedGames.forEach(System.out::println);
							break;
						case 9:
							System.out.println("Exiting the application.");
							return;
						default:
							System.out.println("Invalid choice. Please enter a valid option.");
						}
					}
				}
			} else if (option == 2) {
				System.out.println("Enter Username");
				scanner.nextLine();
				username = scanner.nextLine();
				System.out.println("Enter password");
//				scanner.nextLine();
				password = scanner.next();
				System.out.println("Enter your amount");
				amount = scanner.nextDouble();
				gameService.registerUser(new User(username, password, amount));
			}
			else {
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
		else {
			System.out.println("Invalid choice. Please enter a valid option.");
		}
	}

	private static void displayGames(List<Game> games) {
		for (Game game : games) {
			System.out.println(game);
		}
	}
}
