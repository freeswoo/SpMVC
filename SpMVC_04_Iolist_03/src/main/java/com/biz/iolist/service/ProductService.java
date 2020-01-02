package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.persistence.ProductDao;

@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	
	public List<ProductDTO> getAllList() {
		ProductDao pDao = sqlSession.getMapper(ProductDao.class);
		List<ProductDTO> pList = pDao.selectAll();
		return pList;
	}

	public ProductDTO getProInfo(String p_code) {

		ProductDao pDao = sqlSession.getMapper(ProductDao.class);
		ProductDTO pDTO = pDao.findByPCode(p_code);
		
		return pDTO;
	}

	public int update(ProductDTO proDTO) {
		ProductDao pDao = sqlSession.getMapper(ProductDao.class);
		int ret = pDao.update(proDTO);
		return ret;
	}

	public int delete(String id) {
		ProductDao pDao = sqlSession.getMapper(ProductDao.class);
		int ret = pDao.delete(id);

		return ret;
	}

	

}
