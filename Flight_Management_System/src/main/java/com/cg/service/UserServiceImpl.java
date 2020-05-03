package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.dao.UserDaoI;
import com.cg.entity.User;
import com.cg.errors.UserCreatedException;

@Service
public class UserServiceImpl implements UserServiceI {

	//dao class interface is injected here to use in this class to access methods in dao class.
	@Autowired
	UserDaoI userdao;
	
	// UserCreatedException is custom exception used to show user defined exceptions in the project
	@Override
	public void addUser(User u) throws UserCreatedException
	{
		try
		{
			userdao.addUser(u);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new UserCreatedException("Id already Exist");
		}
	}
	
	@Override
	public User viewUser(BigInteger userId) throws UserCreatedException
	{
		User user = userdao.viewUser(userId);
		
		if(user!=null)
		{
			return user;		
		}
		else
		{
			throw new UserCreatedException("Id not found."); 
		}
	}
		
	@Override
	public List<User> viewUsers()
	{
		
		return userdao.viewUsers();
	}
		

	@Override
	public void updateUser(User user) throws UserCreatedException
	{
		userdao.updateUser(user);
	}

	@Override
	public void deleteUser(BigInteger userId)
	{	
		userdao.deleteUser(userId);
	}
}