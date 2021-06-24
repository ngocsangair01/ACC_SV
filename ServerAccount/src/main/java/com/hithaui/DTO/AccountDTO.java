package com.hithaui.DTO;

public class AccountDTO {
	
	private String username;
	
	private String password;
	
	private String avt;
	private String idFigure;
	private int gold;
	private int diamond;
	private int rankPoint;
	private String friend;
	private String history;
	private String rank;
	private String nameInGame;

//	public AccountDTO(String username, String password, String avt) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.avt = avt;
//	}

	public AccountDTO(String username, String password, String avt, String idFigure, int gold, int diamond, int rankPoint, String friend, String history, String rank, String nameInGame) {
		this.username = username;
		this.password = password;
		this.avt = avt;
		this.idFigure = idFigure;
		this.gold = gold;
		this.diamond = diamond;
		this.rankPoint = rankPoint;
		this.friend = friend;
		this.history = history;
		this.rank = rank;
		this.nameInGame = nameInGame;
	}

	public AccountDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvt() {
		return avt;
	}

	public void setAvt(String avt) {
		this.avt = avt;
	}

	public String getIdFigure() {
		return idFigure;
	}

	public void setIdFigure(String idFigure) {
		this.idFigure = idFigure;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}

	public int getRankPoint() {
		return rankPoint;
	}

	public void setRankPoint(int rankPoint) {
		this.rankPoint = rankPoint;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getNameInGame() {
		return nameInGame;
	}

	public void setNameInGame(String nameInGame) {
		this.nameInGame = nameInGame;
	}
}
