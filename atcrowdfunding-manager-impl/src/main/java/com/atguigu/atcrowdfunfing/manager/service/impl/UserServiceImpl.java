package com.atguigu.atcrowdfunfing.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.exception.LoginFailException;
import com.atguigu.atcrowdfunfing.manager.dao.UserMapper;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.Page;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserlogin(Map<String, Object> paramMap) {
		User user = userMapper.queryUserlogin(paramMap);

		if (user == null) {
			throw new LoginFailException("用户账号或密码不正确");
		}

		return user;
	}

	@Override
	public Page queryPage(Integer pageno, Integer pagesize) {
		Page page = new Page(pageno, pagesize);

		Integer startIndex = page.getStartIndex();

		List<User> datas = userMapper.querList(startIndex, pagesize);

		page.setDatas(datas);

		Integer count = userMapper.queryCount();

		page.setTotalsize(count);

		return page;
	}

	@Override
	public int saveUser(User user) {
		
		return userMapper.insert(user);
	}

}
