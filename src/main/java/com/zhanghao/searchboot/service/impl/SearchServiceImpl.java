package com.zhanghao.searchboot.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhanghao.searchboot.dao.InformationDao;
import com.zhanghao.searchboot.model.Information;
import com.zhanghao.searchboot.service.SearchService;
import com.zhanghao.searchboot.util.http.HttpClientUtil;
import com.zhanghao.searchboot.util.http.HttpResult;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	private static final Logger LOG=LoggerFactory.getLogger(SearchServiceImpl.class);
	
	
	private static final String URL="https://news.baidu.com/widget?id=LocalNews&ajax=json";

	@Autowired
	InformationDao  informationDao;
	
	
	@Autowired
	HttpClientUtil httpClient;
		
	@Override
	public List<Information> search(String word) {
		
		return informationDao.mach(word);
	}

	@Override
    public void importNews() {
        LOG.info("===[开始调用爬取内容方法]===");
        try {
            HttpResult result = httpClient.doPost(URL);
            if (200 == result.getCode()) {
                JSONObject vo = JSON.parseObject(result.getBody());
                JSONArray arr = vo.getJSONObject("data").getJSONObject("LocalNews")
                        .getJSONObject("data").getJSONObject("rows").getJSONArray("first");
                Date date = new Date();
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject o = arr.getJSONObject(i);
                    Information info = new Information();
                    info.setInfoSrc("baidu");
                    info.setInfoImage(o.getString("imgUrl"));
                    info.setInfoText(o.getString("title"));
                    info.setInfoUrl(o.getString("url"));
                    info.setTime(o.getString("time"));
                    info.setSingleTag(DigestUtils.md5DigestAsHex(o.getString("title").getBytes()));
                    info.setCreateTime(date);
                    info.setUpdateTime(date);
                    informationDao.insertIfNotExist(info);
                }
            }
        } catch (Exception e) {
            LOG.error("爬取内容方法异常：excp={}", e);
        }
        LOG.info("===[结束调用爬取内容方法]===");
    }
	
	
	
}
