package com.biz.bok.domain;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name="wantedDtl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BokDetailVO {
	private BokDetailSubVO applmetList;
	private BokDetailSubVO inqplCtadrList;
	private BokDetailSubVO inqplHmpgReldList;
	private BokDetailSubVO basfrmList;
	private BokDetailSubVO baslawList;
}

