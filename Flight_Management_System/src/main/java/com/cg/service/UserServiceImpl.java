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
	User user;
	@Autowired
	UserDaoI userdao;
	
	@Override
	public void addUser(User u) throws UserCreatedException
	{
		try
		{
			userdao.addUser(u);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new UserCreatedException("Id already Exists");
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
			throw new UserCreatedException("Id not found."); 
	}
		
	@Override
	public List<User> viewUsers()
	{
		return userdao.viewUsers();
	}
		
	@Override
	public void updateUser(User user)
	{
		userdao.updateUser(user);
	}

	@Override
	public void deleteUser(BigInteger userId) 
	{	
		userdao.deleteUser(userId);	
	}
}
