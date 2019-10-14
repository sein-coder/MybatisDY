package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Map> selectSearch(SqlSession session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.selectList("emp.selectSearch",param);
	}
	
	
}
