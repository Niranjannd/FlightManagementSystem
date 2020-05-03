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

	// this method add data using entity manager,this is used in login page to signup.
	@Override
	public void addUser(User u) 
	{
		emanager.persist(u);	
	}

	// this method fetch data of a particular user, using unique id given that is given to all users.
	@Override
	public User viewUser(BigInteger userId) 
	{
		return emanager.find(User.class, userId);
	}

	//  this method fetch data of all users on website that they given in signup.
	@Override
	public List<User> viewUsers()
	{
		Query q = emanager.createQuery("from User u");
		return q.getResultList();
	}
	
	// this method update a particular used, first user is searched using his id and than it is updated. 
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
	
	// this method search user using his id and then delete it.
	@Override
	public void deleteUser(BigInteger userId)
	{
		User u=emanager.find(User.class, userId);
		System.out.println(u.getUserId()+" "+u.getUserName());
		emanager.remove(u);
	}
}
