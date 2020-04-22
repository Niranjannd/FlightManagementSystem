package com.cg;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.UserDaoI;

import com.cg.entity.User;

@SpringBootApplication
public class FlightManagementSystemApplication  /*implements CommandLineRunner*/{
	
	@Autowired
	UserDaoI ud;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//			
//		
//		User u1 = new User("Student",BigInteger.valueOf(101),"Rakshit Dogra",456,BigInteger.valueOf(896893558),"RakshitDogra101@gmail.com");
//		User u2 = new User("Employee",BigInteger.valueOf(102),"ND",456,BigInteger.valueOf(896893558),"RakshitDogra101@gmail.com");
//
//		ud.addUser(u1);
//		ud.addUser(u1);
//
//		System.out.println("record inserted");
//		
//	}

}
