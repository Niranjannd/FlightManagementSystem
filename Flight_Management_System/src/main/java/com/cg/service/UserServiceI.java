package com.cg.service;
import java.math.BigInteger;
import java.util.List;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;
import com.cg.entity.User;

@Service
public interface UserServiceI 
{
	public void addUser(User u);
	public User viewUser(BigInteger userId);
	public List<User> viewUsers();
	public void updateUser(User user);
	public void deleteUser (BigInteger userId);
}
