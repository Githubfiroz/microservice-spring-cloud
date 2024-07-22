package com.lwc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.lwc.dao.TeamDao;
import com.lwc.domain.Player;
import com.lwc.domain.Team;

@SpringBootApplication
public class MicroserviceSpringCloudApplication extends SpringBootServletInitializer{

	@Autowired
	TeamDao teamDao;
	
	// Used when run as jar
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSpringCloudApplication.class, args);
	}

	// Used when run as war 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 
		return builder.sources(MicroserviceSpringCloudApplication.class);
	}
	
	/* constructor to add data at load */
	@PostConstruct
	public void init() {
		//List<Team> teamList = new ArrayList<>();
		
		//http://localhost:8080/microservice-spring-cloud/team/Peanuts
		Set<Player> players = new HashSet<>();
		players.add(new Player("Jhon Chena", "pitcher"));
		players.add(new Player("Alex Black", "shortstop"));
		
		Team team = new Team("California", "Peanuts", players);
		teamDao.save(team);
		
		//http://localhost:8080/microservice-spring-cloud/team/Generals
		Set<Player> players1 = new HashSet<>();
		players1.add(new Player("Big Easy", "Showman"));
		players1.add(new Player("Buckets", "Guard"));
		
		Team team1 = new Team("Washington", "Generals", players1);
		teamDao.save(team1);
		
		//http://localhost:8080/microservice-spring-cloud/team/Globetrotters
		Team team2 = new Team("Harlem", "Globetrotters", null);
		teamDao.save(team2);
		
		/*
		teamList.add(new Team("California", "Peanuts", players));
		teamList.add(new Team("Washington", "Generals", null));
		
		teamDao.save(teamList);
		*/
	}
}
