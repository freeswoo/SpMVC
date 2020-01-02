package com.biz.memo.domain;

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
public class HobbyDTO {

    private String h_code;//	varchar2(5)	not null primary key,
    private String h_name;//	nvarchar2(125)	not null,	
    private String h_rem;//	nvarchar2(125)	
    
}
