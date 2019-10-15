package com.mybatis.controller;

import java.io.IOException;
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
 * Servlet implementation class SelectPageServlet
 */
@WebServlet("/selectPage")
public class SelectPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService service = new EmpServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int numPerPage = 5;
		List<Map> list = service.selectPageList(cPage,numPerPage);
		int totalData = service.selectCount();
		
		int totalPage = (int)Math.ceil((double) totalData/numPerPage);
		int pageBarSize = 5;
		String pageBar = "";
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo + pageBarSize -1;
		
		pageBar+= "<ul class='pagination justify-content-center pagination-sm'>";
		
		if(pageNo==1) {
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#' tabindex= -1>이전</a>";
			pageBar += "</li>";
		}else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:void(0);'"
					+ "onclick = 'fn_paging("+(pageNo-1)+");'>이전</a>";
			pageBar += "</li>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='#'>"+pageNo+"</a>";
				pageBar += "</li>";
			}else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='javascript:void(0);'"
						+ "onclick = 'fn_paging("+(pageNo)+");'>"+pageNo+"</a>";
				pageBar += "</li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link'>다음</a>";
			pageBar += "</li>";
		}else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:void(0);'"
					+ "onclick = 'fn_paging("+(pageNo)+");'>다음</a>";
			pageBar += "</li>";
		}
		pageBar += "</ul>";
		
		pageBar += "<script>";
		pageBar += "function fn_paging(cPage){";
		pageBar += "location.href='"+request.getRequestURI()+"?cPage='+cPage";
		// getContextPath() : 서버/프로젝트명
		// getRequestURI() : 서버/프로젝트명/요청한 주소
		pageBar += "}";
		pageBar += "</script>";
		
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/WEB-INF/views/selectPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
