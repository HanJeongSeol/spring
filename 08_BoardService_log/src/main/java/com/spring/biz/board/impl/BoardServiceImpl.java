package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.common.Log4jAdvice;
import com.spring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	// boardDAO 주입
	@Autowired // 타입이 일치하는 객체(인스턴스) 주입
	private BoardDAO boardDAO;
//	private LogAdvice log;
	private Log4jAdvice log4j;

	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl 생성");
		log4j = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.getBoard(vo);
		return vo;
	}

	@Override
	public List<BoardVO> getBoardList() {
		log4j.printLogging();
		List<BoardVO> list = boardDAO.getBoardList();
		return list;
//		return boardDAO.getBoardList();

	}

}
