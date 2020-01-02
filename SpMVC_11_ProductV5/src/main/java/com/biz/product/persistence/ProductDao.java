package com.biz.product.persistence;

import java.util.List;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	
	public long proTotalCount() ;
	
	/*
	 * offset부터 limit까지의 데이터만 추출
	 */
	public List<ProductDTO> selectPagination(PageDTO pageDTO);
	
	public ProductDTO findByPCode(String p_code);
	public List<ProductDTO> findByPNames(String p_name);
	
	// 상품코드의 가장 마지막 값을 가져오기
	public String getMaxPCode();
	
	public int insert(ProductDTO proDTO);
	public int update(ProductDTO proDTO);
	public int delete(String p_code);
	
}
