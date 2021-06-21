package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	// JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// SQL문
	private final String BOARD_INSERT
    = "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
    + "VALUES ((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD), ?, ?, ?) ";

	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE =? , CONTENT =?, WHERE SEQ =?";

	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ =?";

	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ =?";

	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";

	public BoardDAO() {
		System.out.println(">> BoardDAO() 생성");
	}

	// 글 입력
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			
			pstmt.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard() 실행");
		System.out.println("==> JDBC로 updateBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());

			pstmt.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	// 글 상세조회(데이터 하나 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard() 실행");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());

			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt,rs);
		}
		return board;
	}

	// 글 전체조회
	public List<BoardVO> getBoardList() {
		System.out.println("==> JDBC로 getBoardList() 실행");
		
		List<BoardVO> list = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				list.add(board);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt,rs);
		}
		return list;
	}
}
