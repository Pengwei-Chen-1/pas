package com.cpw.test;

import junit.framework.TestCase;

import com.cpw.dao.IUserLoginDao;
import com.cpw.dao.impl.UserLoginDaoImpl;
import com.cpw.factory.DaoFactory;
import com.cpw.pojo.UserLogin;
import com.cpw.util.MD5Util;

public class UserLoginTest extends TestCase {

	IUserLoginDao userLoginDao = (UserLoginDaoImpl)DaoFactory.getDao("userLogin");
	
	public void testGetPassByName(){
		System.out.println(userLoginDao.getPassByName("admin"));
	}
	
	public void testAddUserLogin(){
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("test01");
		userLogin.setUserPass(MD5Util.MD5("test"));
		userLoginDao.addUserLogin(userLogin);
	}
	
	public void testUpdateUserLogin(){
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("test01");
		userLogin.setUserPass(MD5Util.MD5("test01"));
		userLoginDao.updateUserLogin(userLogin);
	}
	
	public void testDelUserLogin(){
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("test01");
		userLoginDao.delUserLogin(userLogin);
	}
	
	public void testGetUserLoginByName(){
		UserLogin userLogin = userLoginDao.getUserLoginByName("admin");
		System.out.println(userLogin.toString());
	}
	
}
