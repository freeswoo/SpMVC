package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

/*
 * @Component Annotation을 대신해서
 * 의미있는 이름으로 설정하기
 * 
 * spring bean으로 클래스를 등록하겠다.
 * conponent-scan base-package에 
 * service package를 등록설정
 */
@Service
public class StudentService {
	
	public List<StudentDTO> getStdList() {
	
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();
		
		StudentDTO stDTO ;// = new StudentDTO();
		stDTO = StudentDTO.builder()
				.st_num("2019001")
				.st_name("홍길동")
				.st_dept("컴퓨터공학과")
				.st_grade(2).build();
		stdList.add(stDTO);
		stDTO = StudentDTO.builder()
				.st_num("2019002")
				.st_name("이몽룡")
				.st_dept("정보통신과")
				.st_grade(3).build();
		stdList.add(stDTO);
		stDTO = StudentDTO.builder()
				.st_num("2019003")
				.st_name("성춘향")
				.st_dept("법학과")
				.st_grade(4).build();
		stdList.add(stDTO);
		stDTO = StudentDTO.builder()
				.st_num("2019004")
				.st_name("임꺽정")
				.st_dept("정치외교학과")
				.st_grade(2).build();
		stdList.add(stDTO);
		stDTO = StudentDTO.builder()
				.st_num("2019005")
				.st_name("장영실")
				.st_dept("천문학과")
				.st_grade(4).build();
		stdList.add(stDTO);
		
		return stdList;
		// return null;
		
	}

}
