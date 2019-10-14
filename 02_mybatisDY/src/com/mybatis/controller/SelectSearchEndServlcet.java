package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmpService;
import com.mybatis.model.service.EmpServiceImpl;

/**
 * Servlet implementation class SelectSearchEndServlcet
 */
@WebServlet("/selectSearchEnd")
public class SelectSearchEndServlcet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSearchEndServlcet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String salary_le_ge = request.getParameter("salary_le_ge");
		String hire_date = request.getParameter("hire_date");
		String hire_date_le_ge = request.getParameter("hire_date_le_ge");
		
		Map<String, String> param = new HashMap();
		
		param.put("type",searchType);
		param.put("key",keyword);
		param.put("gender",gender);
		param.put("salary",salary);
		param.put("flag", salary_le_ge);
		param.put("hire_date",hire_date);
		param.put("hire_date_le_ge",hire_date_le_ge);
		
		List<Map> list = service.selectSearch(param);

		request.setAttribute("emp", list);
		request.getRequestDispatcher("/WEB-INF/views/selectSearch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
