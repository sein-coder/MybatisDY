package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

	List<Map> selectSearch(Map<String,Object> param);
	
	List<Map> selectPageList(int cPage, int numPerPage);
	int selectCount();
	
}
