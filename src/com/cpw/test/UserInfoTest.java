package com.cpw.test;

import java.util.List;

import junit.framework.TestCase;

import com.cpw.dao.IUserInfoDao;
import com.cpw.dao.impl.UserInfoDaoImpl;
import com.cpw.factory.DaoFactory;
import com.cpw.pojo.UserInfo;
import com.cpw.util.DateUtil;

/**
 * 用户信息测试类
 * 
 * @author pengwei_chen
 * @date 2014-3-20 下午3:10:43
 */
public class UserInfoTest extends TestCase {

	IUserInfoDao userInfoDao = (UserInfoDaoImpl) DaoFactory.getDao("userInfo");

	public void testGetAllUserInfo() {
		List<UserInfo> userList = userInfoDao.getAllUser();
		for (UserInfo userInfo : userList) {
			System.out.println(userInfo.toString());
		}
	}

	public void testAddUserInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("test03");
		userInfo.setNickName("test");
		userInfo.setEmail("110@qq.com");
		userInfo.setHeadImage("");
		userInfo.setCreateTime(DateUtil.getNowDate());
		userInfoDao.addUserInfo(userInfo);
	}

	public void testGetUserInfoById() {
		System.out.println(userInfoDao.getUserById(11).toString());
	}

	public void testUpdateUserInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(13);
		userInfo.setUserName("test03");
		userInfo.setNickName("test02");
		userInfo.setEmail("110@qq.com");
		userInfo.setHeadImage("");
		userInfo.setCreateTime(DateUtil.getNowDate());
		userInfoDao.updateUserInfo(userInfo);
	}

	public void testDelUserInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(12);
		userInfoDao.delUser(userInfo);
	}
	
	public void testGetUserInfoByName(){
		String name="admin";
		System.out.println(userInfoDao.getUserByUserName(name).toString());
	}
}
