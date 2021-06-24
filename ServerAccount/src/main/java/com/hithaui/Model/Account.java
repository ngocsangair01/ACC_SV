package com.hithaui.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "acount")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(unique = true)
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
//
//	@CreationTimestamp
//	private Timestamp createAt;
//
//	@UpdateTimestamp
//	private Timestamp updateAt;
	
//	public Account(String username, String password, String avt) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.avt=avt;
//	}


	public Account(Integer accountId, String username, String password, String avt, String idFigure, int gold, int diamond, int rankPoint, String friend, String history, String rank, String nameInGame) {
		this.accountId = accountId;
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

	public String getAvt() {
		return avt;
	}
	public void setAvt(String avt) {
		this.avt = avt;
	}
	public Account() {
		super();
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
	//	public Timestamp getCreateAt() {
//		return createAt;
//	}
//	public void setCreateAt(Timestamp createAt) {
//		this.createAt = createAt;
//	}
//	public Timestamp getUpdateAt() {
//		return updateAt;
//	}
//	public void setUpdateAt(Timestamp updateAt) {
//		this.updateAt = updateAt;
//	}
	
	
	

}
