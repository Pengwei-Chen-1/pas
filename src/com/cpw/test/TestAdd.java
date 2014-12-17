package com.cpw.test;

import junit.framework.TestCase;

import com.cpw.dao.IBusinessDao;
import com.cpw.dao.IFamilyDao;
import com.cpw.dao.IFirstLevelDao;
import com.cpw.dao.impl.BusinessDaoImpl;
import com.cpw.dao.impl.FamilyDaoImpl;
import com.cpw.dao.impl.FirstLevelDaoImpl;
import com.cpw.factory.DaoFactory;
import com.cpw.pojo.Business;
import com.cpw.pojo.Family;
import com.cpw.pojo.FirstLevel;
import com.cpw.util.SysConstant;

public class TestAdd extends TestCase {

	IBusinessDao businessDao = (BusinessDaoImpl)DaoFactory.getDao("business");
	IFamilyDao familyDao = (FamilyDaoImpl)DaoFactory.getDao("family");
	IFirstLevelDao firstLevelDao = (FirstLevelDaoImpl)DaoFactory.getDao("firstLevel");
	
	public void testBusinessAdd(){
		Business business = new Business();
		business.setBusinessName("测试商家");
		business.setUserId(0);
		businessDao.addBusiness(business);
	}
	
	public void testFamilyAdd(){
		Family family = new Family();
		family.setMemberName("测试家庭成员");
		family.setUserId(0);
		familyDao.addFamily(family);
	}
	
	public void testFirstLevelAdd(){
		FirstLevel firstLevel = new FirstLevel();
		firstLevel.setFirstLevelName("测试一级分类");
		firstLevel.setImage("");
		firstLevel.setIoType(SysConstant.IOTYPE_I);
		firstLevel.setUserId(0);
		firstLevelDao.addFirstLevel(firstLevel);
	}
}
