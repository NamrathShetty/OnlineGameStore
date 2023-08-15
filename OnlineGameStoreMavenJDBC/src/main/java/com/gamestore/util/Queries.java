package com.gamestore.util;

public class Queries {

	public static final String CREATEQUERY=
			"create table if not exists game(gameName varchar(50), gameId int primary key auto_increment, gamePrice double, gameGenre varchar(50), gameDeveloper varchar(50), gameRating int)";
	public static final String INSERTQUERY=
			"insert into game(gameName, gamePrice, gameGenre, gameDeveloper, gameRating)values(?,?,?,?,?)";
	
	public static final String UPDATEPRICEQUERY="update game set gamePrice=? where gameId=?";

	public static final String UPDATERATINGQUERY="update game set gameRating=? where gameId=?";
	
	public static final String QUERYBYID="select * from game where gameId=?";
	
	public static final String SELECTQUERY="select * from game";
	
	public static final String QUERYBYDEVELOPER="select * from game where gameDeveloper like ?";
	
	public static final String QUERYBYGENRE="select * from game where gameGenre like ?";
	
	public static final String QUERYBYDEVELOPERANDGENRE="select * from game where gameDeveloper like ? and gameGenre like ?";
	
	public static final String DELETEQUERY="delete from game where gameId=?";
	
	public static final String QUERYBYPRICE="select * from game where gamePrice<?";
	
	public static final String CREATEUSERQUERY="create table if not exists newUser(userName varchar(50), userId int primary key auto_increment, password varchar(20) not null,amount double)";

	public static final String INSERTUSERQUERY="insert into newUser(userName, password,amount)value(?,?,?)";

	public static final String SELECTUSERQUERY="select * from newUser where userId=?";
	
	public static final String SELECTALLUSERQUERY="select * from newUser";
	
	public static final String UPDATEUSERQUERY="update newUser set amount=? where userId=?";
	
	public static final String SELECTUSERBYID="select * from newUser where userId=?";

	public static final String DELETEUSERQUERY="delete from newUser where userId=?";
		
	public static final String CREATEPURCHASEQUERY="create table if not exists purchase(purchaseId int primary key auto_increment,userId int, gameId int,foreign key(userId) references newUser(userId), foreign key (gameId) references game(gameId));";
	
	public static final String INSERTPURCHASEQUERY="insert into purchase(userId,gameId)value(?,?)";
	
	public static final String SELECTPURCHASEQUERY="select * from purchase where purchaseId=?";

	public static final String SELECTUSERPURCHASEDQUERY="select * from purchase where userId=?";
	
	public static final String DELETEPURCHASEQUERY="delete from purchase where purchaseId=?";		
	
}
