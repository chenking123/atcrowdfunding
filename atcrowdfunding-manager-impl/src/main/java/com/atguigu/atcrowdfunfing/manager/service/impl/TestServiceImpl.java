package com.atguigu.atcrowdfunfing.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunfing.manager.dao.TestDao;
import com.atguigu.atcrowdfunfing.manager.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;


	@Override
	public void insert() {
		Map map=new HashMap();
		map.put("name","zhangsan");
		testDao.insert(map);
	}

}
