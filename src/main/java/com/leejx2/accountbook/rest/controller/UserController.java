package com.leejx2.accountbook.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leejx2.accountbook.rest.model.User;
import com.leejx2.accountbook.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/rest/users")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/rest/user/{loginId}")
	@ResponseBody
	public User getUser(@PathVariable("loginId") String loginId) {
		return userService.getUser(loginId);
	}
	
	@PostMapping("/rest/usradd")
	public void addUser(@ModelAttribute("params") User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/rest/cfgupd")
	public void setUserConfig(@ModelAttribute("params") User user) {
		userService.setUserConfig(user);
	}
	
	@DeleteMapping("/rest/usrdel")
	public void delUser(@ModelAttribute("params") User user) {
		userService.delUser(user);
	}
}
