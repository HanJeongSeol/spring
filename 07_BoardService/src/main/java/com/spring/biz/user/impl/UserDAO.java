package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// SQL문
	private final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD =? ";
	private final String USER_LIST = "SELECT * FROM USERS ORDER BY ID DESC";
	private final String USER_INSERT = "INSERT INTO USERS VALUES(?,?,?,?) ";
	private final String USER_DELETE = "DELETE USERS WHERE NAME = ?";

	public int deleteUser() {
		System.out.println("==> JDBC로 deleteUser() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_DELETE);
			pstmt.setString(1, "테스트3");

			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return 0;
	}

	public int setUser() {
		System.out.println("==> JDBC로 setUser() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, "test4");
			pstmt.setString(2, "test4");
			pstmt.setString(3, "테스트4");
			pstmt.setString(4, "User");

			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return 0;
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("==> JDBC로 getUser() 실행");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getString("ROLE"));
//				user.setId(rs.getString("ID"));
//				user.setPassword(rs.getString("PASSWORD"));
//				user.setName(rs.getString("NAME"));
//				user.setRole(rs.getString("ROLE"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return user;
	}

	public List<UserVO> getUserList() {
		System.out.println("==> JSDB로 getUserList() 실행");
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_LIST);

			rs = pstmt.executeQuery();
			UserVO vo = null;
			while (rs.next()) {
				vo = new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getString("ROLE"));
				userList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return userList;
	}
}
