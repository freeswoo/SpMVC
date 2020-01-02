package com.biz.travel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.travel.domain.QnADTO;
import com.biz.travel.domain.UserDTO;
import com.biz.travel.service.QnAService;

@SessionAttributes("qnaDTO")

@RequestMapping(value="/qna")
@Controller
public class QnAController {
/*
 * 질답게시판. SpMVC 04 참조해서
 * 
 * 글쓴 시간, 제목, 내용, id(혹은 닉네임). 로그인시에만 가능하게
 * 
 * 게시판 글쓰기, 수정, 삭제기능(삭제는 영구 삭제가 아니라 삭제여부 확인해서 자료를 보이지 않게)
 */
	@Autowired
	QnAService qService;
	
	@ModelAttribute("qnaDTO")
	public QnADTO makeQnADTO() {
		QnADTO qnaDTO = new QnADTO();
		return qnaDTO;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(String search, Model model) {
		List<QnADTO> qnaList;
		if(search == null || search.isEmpty()) { // 검색어가 없으면 전부 불러오기
			qnaList = qService.getAllList();
		}
		else { // 검색어가 있으면 검색어 있는 리스트만 불러오기
			qnaList = qService.getSearchList(search);
		}
		model.addAttribute("qnaList", qnaList);
		return "/qna/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(
				@ModelAttribute("qnaDTO") QnADTO qnaDTO, Model model, HttpSession httpSession) {

		UserDTO userDTO 
			= (UserDTO)httpSession.getAttribute("userDTO");
		
		if(userDTO == null) {
			model.addAttribute("BODY","LOGIN");
			model.addAttribute("LOGIN_MSG","TRY");
			return "redirect:/user/login";
		}
		
		Date date = new Date();
		SimpleDateFormat sd 
		= new SimpleDateFormat("yyyy-MM-dd/");
		SimpleDateFormat st 
		= new SimpleDateFormat("HH:mm:ss");
		
		qnaDTO.setQna_date(sd.format(date) + st.format(date));
		qnaDTO.setQna_id(userDTO.getUser_id());
		
		model.addAttribute("BODY","QNA_WR");
		model.addAttribute("qnaDTO",qnaDTO);
		return "/qna/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("qnaDTO") QnADTO qnaDTO, String search, Model model,SessionStatus sStatus) {
		int ret = qService.insert(qnaDTO);
		sStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@RequestParam("id") String str_seq, 
				@ModelAttribute QnADTO qnaDTO,
				Model model) {
		
		qnaDTO = qService.findBySeq(str_seq);

			model.addAttribute("qnaDTO",qnaDTO);
			model.addAttribute("BODY","QNA_VI");
			return "/qna/view";
	}
	
}
