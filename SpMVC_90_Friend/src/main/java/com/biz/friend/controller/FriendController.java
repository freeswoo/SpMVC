package com.biz.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.service.FriendService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("friendVO")
@RequestMapping(value="/friend")
@Controller
public class FriendController {

	private final FriendService fService;
	
	public FriendController(
			@Qualifier("fService") FriendService fService) {
		super();
		this.fService = fService;
	}
	
	@ModelAttribute("friendVO")
	public FriendVO makeFriendVO() {
		return new FriendVO();
	}
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String selectAll(Model model) {
		
		List<FriendVO> friendList = fService.selectAll();
		model.addAttribute("FRIEND_LIST",friendList);
		model.addAttribute("BODY","FRIEND_LIST");
		
		return "home";
	}
	
	@RequestMapping(value="/input",method = RequestMethod.GET)
	public String input(Model model) {
		
		//model.addAttribute("friendVO",friendVO);
		model.addAttribute("BODY","FRIEND_INPUT");
		return "home";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("friendVO") FriendVO friendVO, SessionStatus status) {
		
		fService.save(friendVO);
		status.setComplete();
		return "redirect:/friend/list";
	}
	
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(@ModelAttribute("friendVO") FriendVO friendVO, Model model) {
		
		friendVO = fService.findById(friendVO.getFriend_id());
		model.addAttribute("friendVO",friendVO);
		model.addAttribute("BODY","FRIEND_VIEW");
		return "home";
	}
	
	
	
}
