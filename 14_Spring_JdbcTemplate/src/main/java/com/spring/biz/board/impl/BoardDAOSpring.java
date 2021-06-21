package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
		private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT
    = "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
    + "VALUES ((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD), ?, ?, ?) ";

	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE =? , CONTENT =?, WHERE SEQ =?";

	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ =?";

	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ =?";

	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";

	public BoardDAOSpring() {
		System.out.println(">> BoardDAOSpring() 객체 생성");
	}
	
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Spring JDBC로 insertBoard() 실행");
		
		// vo에서 가져오면 된다. INSERT 쿼리문에서 물음표에 할당할 것들
		// update 메소드가 Object형태의 배열을 받고있기 때문에 배열을 넘긴다
		Object[] args= {vo.getTitle(),vo.getWriter(),vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT,args);
		
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("==> Spring JDBC로 updateBoard() 실행");
		
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> Spring JDBC로 deleteBoard() 실행");
		jdbcTemplate.update(BOARD_DELETE,vo.getSeq());

	}

	// 글 상세조회(데이터 하나 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> Spring JDBC로 getBoard() 실행");
		BoardVO board = null;
		Object[] args= {vo.getSeq()};
		// 조회할때는 queryForObject사용
		// (쿼리문, ?바인딩할 데이터, rowMapper)
		// rowMapper은 클래스 하나 만들어서 작성해야한다. 인터페이스 구현 방식
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	// 글 전체조회
	public List<BoardVO> getBoardList() {
		System.out.println("==> JDBC로 getBoardList() 실행");
		List<BoardVO> list = null;
		
		// 쿼리문에 넣을 데이터가 없기때문에 query 사용
		// 반환하는 데이터 타입이 반환타입과 동일하다면 바로 반환하면된다.
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		
	}
}
