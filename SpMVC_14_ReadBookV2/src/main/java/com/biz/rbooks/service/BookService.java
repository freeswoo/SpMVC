package com.biz.rbooks.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.repository.BookDao;

import lombok.RequiredArgsConstructor;

/*
 * private final로 설정된 필드변수들의 
 * 생성자를 생성하고 자동 inject(@Autowired)를 수행 해준다.
 */
@RequiredArgsConstructor
@Service
public class BookService {

	private final BookDao bookDao;
	
	public List<BookVO> selectAll() {
		return bookDao.selectAll();
	}

	public void insert(BookVO bookVO) {

		Random rnd = new Random();
		String b_code = rnd.nextGaussian() + "";
		
		bookVO.setB_code(b_code);
		bookVO.setB_name("연습하기");
		bookVO.setB_auther("홍길동");
		
		bookDao.insert(bookVO);
		
	}
	
}
