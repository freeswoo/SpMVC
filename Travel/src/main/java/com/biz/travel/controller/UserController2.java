package com.biz.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.travel.domain.UserDTO;
import com.biz.travel.domain.UserDTO2;
import com.biz.travel.service.UserService2;
/*
 * 회원가입, 로그인, 정보수정 기능하는 컨트롤러
 * 
 * USER table
 * id, passwd, name, tel, 회원탈퇴여부
 */
@RequestMapping(value="/user2")
@Controller
public class UserController2 {
	
	@Autowired
	UserService2 jService;

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		UserDTO uDTO = new UserDTO();
		model.addAttribute("userDTO", uDTO);
		return "user/insert4";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, @ModelAttribute("userDTO") UserDTO2 uDTO) {
		jService.insert(uDTO);
		return "redirect:https://localhost:8080/";
	}
	
	@RequestMapping(value="/idcheck",method=RequestMethod.GET)
	public String userIdCheck(String u_id,Model model) {
		
		/*
		 * idYes : true : 등록된 회원id가 있다
		 * 		false : 아직 등록된 회원id가 없다
		 */
		boolean idYes = jService.userIdCheck(u_id);
		model.addAttribute("ID_YES",idYes);
		model.addAttribute("u_id",u_id);		
		// return "user/idcheck";
		return null;
	
	}
}
