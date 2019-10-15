package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {
	
	@Override
	public List<Map> selectPageList(SqlSession session, int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		//1. RowBounds객체를 사용한다.
		//생성시에 paging처리에 대한 값을 대입(매개변수)
		//offset : 출력될 데이터 범위, *시작점으로 봐도 무방
		// - (cPage-1)*numPerPage
		//limit : 몇개까지 출력할 것인지, *numPerPage
		// - numPerPage
		RowBounds r = new RowBounds((cPage-1)*numPerPage, numPerPage);
		//두번째 자리는 파라미터인데 넘겨줄 값이 없기때문에 null을 넣어준다.
		return session.selectList("emp.selectPageList", null, r);
	}

	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.selectCount");
	}

	@Override
	public List<Map> selectSearch(SqlSession session, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return session.selectList("emp.selectSearch",param);
	}
	
	
}
