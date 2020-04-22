package com.cg.controller;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.User;
import com.cg.service.UserServiceI;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController
{
	
	@Autowired
	UserServiceI userserv;
	
	
	@PostMapping(value="/user/new",consumes= {"application/json"})
	public String addUser(@RequestBody User user)
	{
		userserv.addUser(user);
		return "User Added";	
	}
		
	
	@GetMapping(value="/user/{userId}")
	public User viewUser(@PathVariable BigInteger userId)
	{
		return userserv.viewUser(userId);
	}
		
	
	@GetMapping(value="/user")
	public List<User> viewUsers()
	{
		return userserv.viewUsers();		
	}
	
	
	@PutMapping(value="/user/update",consumes= {"application/json"})
	public String updateUser(@RequestBody User user)
	{
		userserv.updateUser(user);
		return "User Updated";
	}
	
	@DeleteMapping(value="/user/delete/{userId}")
	public String deleteUser(@PathVariable BigInteger userId)
	{
		userserv.deleteUser(userId);
		return "student deleted";
	}

	
}


