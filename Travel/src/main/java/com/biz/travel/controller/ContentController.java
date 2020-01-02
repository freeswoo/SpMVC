package com.biz.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.travel.domain.ContentDTO;
import com.biz.travel.service.ContentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/content")
@Controller
public class ContentController {
/*
 * 내용 들어갈 게시판. SpMVC 04 참조. DB에서 여행지 자료 List로 가져와서 뿌리기. 지역별 구분은 js에서 href query로
 * .jsp파일에서 JS로 작성된 지도API 참조해서 클릭하면 a href로(혹은 JS .click 사용) 페이지 불러오는 작업들의 컨트롤러
 * 
 */
	@Autowired
	ContentService cService;
	
	
	@RequestMapping(value="/spring",method = RequestMethod.GET)
	public String springMap() {
		return "/content/spring/map";
	}
	
	@RequestMapping(value="/winter",method = RequestMethod.GET)
	public String winterMap() {
		return "/content/winter/map";
	}
	
	@RequestMapping(value="/springview",method=RequestMethod.GET)
	public String springView(int travel_season, String travel_devide, Model model) {
//		List<ContentDTO> cList = cService.findBySeason(travel_season);
		log.debug("travel_season : " + travel_season);
		log.debug("travel_devide : " + travel_devide);
		List<ContentDTO> cList = cService.findBySeasonAndDevide(travel_season, travel_devide);
		log.debug("cList값 : " + cList.toString());
		model.addAttribute("cList",cList);
		return "/content/spring/list";
	}
	
	@RequestMapping(value="/winterview",method=RequestMethod.GET)
	public String winterView(int travel_season, String travel_devide, Model model) {
//		List<ContentDTO> cList = cService.findBySeason(travel_season);
		log.debug("travel_season : " + travel_season);
		log.debug("travel_devide : " + travel_devide);
		List<ContentDTO> cList = cService.findBySeasonAndDevide(travel_season, travel_devide);
		log.debug("cList값 : " + cList.toString());
		model.addAttribute("cList",cList);
		return "/content/spring/list";
	}
}
