package com.mybatis.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmpDao;
import com.mybatis.model.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {

	private EmpDao dao = new EmpDaoImpl();
	
	@Override
	public List<Map> selectSearch(Map<String, String> param) {
		SqlSession session = getSession();
		List<Map> list = dao.selectSearch(session,param);
		return list;
	}
	
	
}
