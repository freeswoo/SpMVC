package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	public ProductDTO findByPCode(String p_code);
	public int update(ProductDTO proDTO);
	public int delete(String id);

}
