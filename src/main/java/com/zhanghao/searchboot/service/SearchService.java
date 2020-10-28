package com.zhanghao.searchboot.service;

import java.util.List;

import com.zhanghao.searchboot.model.Information;

public interface SearchService {

	
	List<Information> search(String word);
}
