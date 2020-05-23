package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="TeamData")
public class Team {//Team team = new Team();
	@Id
	//@GeneratedValue
	private int teamId;
	@Column(name="team_Name")
	private String teamName;
	@Column(name="no_Of_Players")
	private int noOfPlayers;
	public Team() {
		super();
	}
	public Team(int teamId, String teamName, int noOfPlayers) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.noOfPlayers = noOfPlayers;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getNoOfPlayers() {
		return noOfPlayers;
	}
	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", noOfPlayers=" + noOfPlayers + "]";
	}
	
	

}
