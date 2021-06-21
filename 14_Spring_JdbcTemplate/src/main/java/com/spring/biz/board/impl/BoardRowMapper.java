package com.spring.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	// ResultSet에서 꺼낸 후 BoardVO에 넣어주면 된다
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegdate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));

		return board;
	}

}
