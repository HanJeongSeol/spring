package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	// boardDAO 주입
	@Autowired // 타입이 일치하는 객체(인스턴스) 주입
	private BoardDAO boardDAO;
	
	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl 생성");
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		boardDAO.getBoard(vo);
		return vo;
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = boardDAO.getBoardList();
		return list;
//		return boardDAO.getBoardList();

	}

}
