package com.zhanghao.searchboot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanghao.searchboot.dao.InformationDao;
import com.zhanghao.searchboot.model.Information;
import com.zhanghao.searchboot.service.SearchService;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	private static final Logger LOG=LoggerFactory.getLogger(SearchServiceImpl.class);

	@Autowired
	InformationDao  informationDao;
		
	@Override
	public List<Information> search(String word) {
		
		return informationDao.mach(word);
	}
	
	
	
}
