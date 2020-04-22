package com.cg.dao;

import java.math.BigInteger;
import java.util.List;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Repository;
import com.cg.entity.User;

@Repository
public interface UserDaoI
{
	public void addUser(User u);
	public User viewUser(BigInteger userId);
	public List<User> viewUsers();
	public void updateUser(User user);
	public void deleteUser (BigInteger userId);		
}
