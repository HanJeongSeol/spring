package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.impl.BoardServiceImpl;

public class BoardServiceClient {
	public static void main(String[] args) {

		System.out.println("------ 스프링 컨테이너 구동전 ------");

		// 1. 스프링컨테이너 구동(스프링 설정파일 읽어서)
		// factory 역할을 한다
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("------ 스프링 컨테이너 구동후 ------");

		// 2. 스프링컨테이너 사용
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 2-1. 입력
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트");
		vo.setWriter("홍길동");
		vo.setContent("테스트 - 내용");

//		try {
//			boardService.insertBoard(vo);
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
		boardService.insertBoard(vo);
		
		// 전체목록조회
		List<BoardVO> list = boardService.getBoardList();
		for (BoardVO board : list) {
			System.out.println(board);
		}

		// 3. 스프링컨테이너 종료(close 처리)
		System.out.println("------ 스프링 컨테이너 종료처리 ------");
		container.close();

	}
}
