package com.cpw.test;

import java.util.List;

import junit.framework.TestCase;

import com.cpw.dao.IAccountDao;
import com.cpw.dao.impl.AccountDaoImpl;
import com.cpw.factory.DaoFactory;
import com.cpw.pojo.Account;

public class AccountTest extends TestCase {

	IAccountDao accountDao = (AccountDaoImpl)DaoFactory.getDao("account");
	
	public void testGetAllAccount(){
		List<Account> accountList = accountDao.getAllAccount();
		for (Account account : accountList) {
			System.out.println(account.toString());
		}
	}
	
	public void testAddAccount(){
		Account account = new Account();
		account.setAccountName("账户测试1");
		account.setUserId(0);
		accountDao.addAccount(account);
	}
	
	public void testUpdateAccount(){
		Account account = new Account();
		account.setAccountId(7);
		account.setAccountName("账户测试11");
		account.setUserId(0);
		accountDao.updateAccount(account);
	}
	
	public void testDel(){
		Account account = new Account();
		account.setAccountId(7);
		accountDao.deleteAccount(account);
	}
}
