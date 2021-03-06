package com.spring.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.biz.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 요청처리 작업 진행
		System.out.println(">> DispatcherServlet.process() : *.do 요청에 대한 처리");

		// 1. 클라이언트에서 어떤 작업을 요청했는지 확인하기
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);

		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path);
		String returnStr = "";

		// 2. 클라이언트 요청형태에 따른 작업 처리
		if ("/login.do".equals(path)) {
			System.out.println(">> 로그인 처리 ");

			// 1. 사용자가 입력한 데이터(정보) 확인(추출)
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB연동작업(id, password 유저 확인)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			// 로그인 성공 : 게시글 목록 보여주기
			// 로그인 실패 : 로그인 화면으로 이동
			if (user != null) { // 사용자 정보가 있는 경우
				System.out.println(">> 로그인 성공 !!!!!");
//				response.sendRedirect("getBoardList.do");
				returnStr = "getBOardList.do";
			} else {
				System.out.println(">> 로그인 실패~~");
//				response.sendRedirect("login.jsp");
				returnStr = "login.jsp";
			}
		}
		return returnStr;
	}
}