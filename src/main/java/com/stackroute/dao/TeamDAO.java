package com.stackroute.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.stackroute.model.Team;
@Repository
@Transactional
public class TeamDAO {
	public static List<Team> teamList;
	@Autowired
	SessionFactory sessionFactory;
	public List<Team> getTeams(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Team");
		List<Team> teamList = query.list();
		for (Team team : teamList) {
			System.out.println(team);
		}
		return teamList;
	}
//	public Team getTeamById(int id) {
//		for (Team team : teamList) {
//			if(team.getTeamId()==id)
//				return team;
//		}
//		return null;
//	}
	
	public boolean addTeam(Team team) {
		if(team==null)
			return false;
		Session session = sessionFactory.getCurrentSession();
		session.save(team);
		return true;
		
	}
	
	
	
	
	
	
	
	
	

}
