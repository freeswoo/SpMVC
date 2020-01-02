package com.biz.memo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ScriptAssert(
			lang="javascript",
			script="(_this.u_password == _this.re_password)",
			reportOn="re_password",
			message="비밀번호와 확인 비번이 다름!!!")
public class UserDTO {

	/*
	 * @Eamil : email 형식 검사
	 * @NotBlank : 공백검사
	 * @NotNull : null이 아닐경우만 정상
	 * @Null : null 일경우만 정상
	 * @Max(x), @Minx(x) : 숫자의 최대값 최소값 제한
	 * @Size(min=x,max=x) : 문자열일 경우
	 * @DecimalMax(x) : x값 이하의 실수
	 * @DecialMin(x) : x값 이상의 실수
	 * @Digtis(integer=x) : x 자릿수 이하의 정수
	 * @Digits(integer=x, fraction=y) : 
	 * 		x 자릿수 이하하의 정수이면서
	 * 		y 자릿수 이하 소수점 자릿수
	 * 
	 */
	
	@NotNull
	@NotBlank(message = "공백이면 안되")
	@Email(message = "* 이메일형식으로만 써!!!")
	@Size(min = 5, max=100)
	private String u_id;
	
	private String u_password;
	private String re_password;
		
	private String u_name;
	
	@NotBlank(message = "* 닉네임은 비어있으면 안되!!!")
	private String u_nick;
	private String u_grade;
	
	// 정규형 표현식
	@Pattern(regexp = "\\d{1,15}",
			message="1~15자리 까지의 숫자만 가능")
	private String u_tel;
	
}
