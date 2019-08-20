package com.atguigu.atcrowdfunfing.manager.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.exception.LoginFailException;
import com.atguigu.atcrowdfunfing.manager.dao.UserMapper;
import com.atguigu.atcrowdfunfing.manager.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserlogin(Map<String, Object> paramMap) {
		User user = userMapper.queryUserlogin(paramMap);
		
		if(user==null) {
			throw new LoginFailException("用户账号或密码不正确");
		}
		
		return user;
	}
	
	
	
}
