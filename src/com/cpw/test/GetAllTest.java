package com.cpw.test;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.cpw.dao.ILogInfoDao;
import com.cpw.dao.ISecondLevelDao;
import com.cpw.dao.ISpendingDao;
import com.cpw.dao.ITemplateDao;
import com.cpw.dao.impl.LogInfoDaoImpl;
import com.cpw.dao.impl.SecondLevelDaoImpl;
import com.cpw.dao.impl.SpendingDaoImpl;
import com.cpw.dao.impl.TemplateDaoImpl;
import com.cpw.factory.DaoFactory;
import com.cpw.pojo.LogInfo;
import com.cpw.pojo.SecondLevel;
import com.cpw.pojo.Spending;
import com.cpw.pojo.Template;
import com.cpw.util.DateUtil;
import com.cpw.util.LogUtil;

public class GetAllTest extends TestCase {

	ISecondLevelDao secondLevelDao = (SecondLevelDaoImpl)DaoFactory.getDao("secondLevel");
	ITemplateDao tempDao = (TemplateDaoImpl)DaoFactory.getDao("template");
	ISpendingDao spendingDao = (SpendingDaoImpl)DaoFactory.getDao("spending");
	ILogInfoDao logDao = (LogInfoDaoImpl)DaoFactory.getDao("logInfo");
	
	public void getAllSecondLevel(){
		List<SecondLevel> secondLevelList = secondLevelDao.getAllSecondLevel();
		for (SecondLevel secondLevel : secondLevelList) {
			System.out.println(secondLevel.toString());
		}
	}
	
	public void getTemplateByTerm(){
		String term = "ioType = 'O'";
		List<Template> tempList = tempDao.getTemplate(term);
		for (Template template : tempList) {
			System.out.println(template.toString());
		}
	}
	
	public void getSpendingByTerm(){
		String term = "date_format(CREATETIME,'%Y-%m') = date_format(now(),'%Y-%m')";
		List<Spending> sList = spendingDao.getSpendingByTerm(term);
		for (Spending spending : sList) {
			System.out.println(spending.toString());
		}
	}
	
	public void testLog(){
		LogUtil.addLog("O", "测试日志");
	}
	
	public void testGetLog(){
		List<LogInfo> logList = logDao.getLogInfo(4, 4);
		for (LogInfo logInfo : logList) {
			System.out.println(logInfo.toString());
		}
	}
	
	public void testGetCount(){
		System.out.println(logDao.getCount()+"");
	}
	
	public void testGetDate(){
		System.out.println(DateUtil.getNowDateStr(new Date()));
	}
}

