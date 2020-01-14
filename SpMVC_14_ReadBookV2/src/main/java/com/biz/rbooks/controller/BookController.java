package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/book")
public class BookController {
	
	private final BookService bService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BookVO> bookList = bService.selectAll();
		
		model.addAttribute("BLIST",bookList);
		return "books/list";
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		
		bService.insert(bookVO);
		return "redirect:/book/list";
	}

}
