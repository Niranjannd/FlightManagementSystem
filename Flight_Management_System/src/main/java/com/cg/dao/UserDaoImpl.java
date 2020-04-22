package com.cg.dao;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Repository;
import com.cg.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDaoI {

	@PersistenceContext
	EntityManager emanager;
	
	@Override
	public void addUser(User u) 
	{
		emanager.persist(u);	
	}

	@Override
	public User viewUser(BigInteger userId) 
	{
		return emanager.find(User.class, userId);
	}

	@Override
	public List<User> viewUsers()
	{
		Query q = emanager.createQuery("from User u");
		return q.getResultList();
	}

	@Override
	public void updateUser(User user) 
	{
		User u=emanager.find(User.class, user.getUserId());
		
		u.setUserType(user.getUserType());
		u.setUserId(user.getUserId());
		u.setUserName(user.getUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserPhone(user.getUserPhone());
		u.setUserEmail(user.getUserEmail());
	
	}
	
	@Override
	public void deleteUser(BigInteger userId)
	{
		User u=emanager.find(User.class, userId);
		System.out.println(u.getUserId()+" "+u.getUserName());
		emanager.remove(u);
	}

}
