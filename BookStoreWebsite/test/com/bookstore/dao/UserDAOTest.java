package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest{
	
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		userDAO = new UserDAO();
		
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("john@gmail.com");
		user1.setFullName("John Smith");
		user1.setPassword("john");
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateFieldsNotSet() {
		
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);
		
	}
	
	@Test
	public void testUpdateUsers() {
		
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("phu@codejava.net");
		user.setFullName("Vu Duc Phu");
		user.setPassword("mysecret");
		
		user = userDAO.update(user);
		String expected = "mysecret";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		
		Integer userId = 1;
		Users user = userDAO.get(userId);
		
		if(user != null) {
			System.out.println(user.getEmail());
		}
		
		assertNotNull(user);
	}
	
	@Test
	public void testGetUserNotFound() {
		
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		
		Integer userId = 2;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class) //throws an exception
	public void testDeleteNonExistUsers() {
		
		Integer userId = 55;
		userDAO.delete(userId);
		
	}
	
	@Test
	public void testListAll() {
		
		List<Users> listUsers = userDAO.listAll();
		for(Users user: listUsers) {
			System.out.println(user.getEmail());
		}
		assertTrue(listUsers.size() > 0);
		
	}
	
	@Test
	public void testCount() {
		
		long totalUsers = userDAO.count();
		assertEquals(2, totalUsers);
		
	}
	
	@Test
	public void testFindByEmail() {
		String email="pikachu@email.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	
	@Test
	public void testCheckLoginSuccess(){
		String email = "admin.book@gmail.com";
		String password = "admin";
		boolean loginResult = userDAO.checkLogin(email, password);
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed(){
		String email = "admin123.book@gmail.com";
		String password = "admin";
		boolean loginResult = userDAO.checkLogin(email, password);
		assertFalse(loginResult);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO.close();
	}

}
