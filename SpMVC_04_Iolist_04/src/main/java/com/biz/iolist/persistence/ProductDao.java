package com.biz.iolist.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	public ProductDTO findByPCode(String p_code);
	public int update(ProductDTO proDTO);
	public int delete(String id);
	public List<ProductDTO> findByName(@Param("p_name") String strText);

}
