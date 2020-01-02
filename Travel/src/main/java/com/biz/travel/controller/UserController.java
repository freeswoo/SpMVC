package com.biz.travel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.travel.domain.UserDTO;
import com.biz.travel.service.UserService;

import lombok.extern.slf4j.Slf4j;
/*
 * 회원가입, 로그인, 정보수정 기능하는 컨트롤러
 * 
 * USER table
 * id, passwd, name, 회원탈퇴여부
 */
@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	UserService jService;

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		UserDTO uDTO = new UserDTO();
		model.addAttribute("userDTO", uDTO);
		return "user/insert";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, @ModelAttribute("userDTO") UserDTO uDTO) {
		jService.insert(uDTO);
		log.debug("회원가입할 DTO 정보 : " + uDTO.toString());
		return "redirect:/login";
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
		return "user/idcheck";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login( 
		@RequestParam(value="LOGIN_MSG",
						required = false,
						defaultValue = "0") String msg,
						Model model) {
		
		model.addAttribute("LOGIN_MSG",msg);
		model.addAttribute("BODY","LOGIN");
		return "user/login";
	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
				String BODY,
				@ModelAttribute UserDTO userDTO, 
				Model model,
				HttpSession httpSession) {
		
		boolean loginOk = jService.userLoginCheck(userDTO);
		
		// 로그인한 사용자 ID와 password를 
		// DB정보화 일치하는 검사
		if(loginOk == true) {
			httpSession.setMaxInactiveInterval(10*60);
			
			// db로 부터 사용자 정보를 가져오자
			userDTO = jService.getUser(userDTO.getUser_id());
			httpSession.setAttribute("userDTO", userDTO);
		} else {
			httpSession.removeAttribute("userDTO");
			model.addAttribute("LOGIN_MSG","FAIL");
			return "redirect:/user/login";
		}
		// model.addAttribute("BODY",BODY);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");
		
		return "redirect:/";
	}
}
