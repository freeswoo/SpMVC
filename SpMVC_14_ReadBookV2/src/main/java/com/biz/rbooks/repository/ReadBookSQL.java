package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class ReadBookSQL {

	public String update_sql() {
		
		SQL sql = new SQL() {{
			
			UPDATE("tbl_read_book");
			WHERE("rb_seq = #{rb_seq,jdbcType=VARCHAR}");
			SET("rb_bcode = #{rb_bcode,jdbcType=VARCHAR}");
			SET("rb_date = #{rb_date,jdbcType=VARCHAR}");
			SET("rb_stime = #{rb_stime,jdbcType=VARCHAR}");
			SET("rb_rtime = #{rb_rtime,jdbcType=VARCHAR}");
			SET("rb_subject = #{rb_subject,jdbcType=VARCHAR}");
			SET("rb_text = #{rb_text,jdbcType=VARCHAR}");
			SET("rb_star = #{rb_star,jdbcType=VARCHAR}");
			
		}};
		
		return sql.toString();
	}
	
}
