package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

	List<Map> selectSearch(Map<String,String> param);
	
}
