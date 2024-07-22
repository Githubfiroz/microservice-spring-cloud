package com.lwc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwc.dao.TeamDao;
import com.lwc.domain.Player;
import com.lwc.domain.Team;

// Instead of @Controller  I am using @RestController and for that
// I need to remove @ResponseBody from method
//@Controller


@RestController
public class CloudController {
	
	@Autowired
	TeamDao teamDao;
	
	@RequestMapping("/team/{name}")
	public Team teamDetails(@PathVariable String name) {
		return teamDao.findByName(name);
	}
	
	
	/*
	//private Team team;
	@RequestMapping("/team")
	public Team teamDetails() {
		return team;
	}
	/*
	@RequestMapping("/team")
	public @ResponseBody Team teamDetails() {
		return team;
	}
	*/
	@RequestMapping("/hi")
	public @ResponseBody String greetings() {
		return "Hi-Hello World!";
	}

	@RequestMapping("/hi/{name}")
	public String greetings(Map model, @PathVariable String name) {
		model.put("name", name);

		return "hello";
	}

}
