package com.atguigu.atcrowdfunfing.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.util.Page;

public interface UserService {

	User queryUserlogin(Map<String, Object> paramMap);

	Page queryPage(Integer pageno, Integer pagesize);
	
	int saveUser(User user);
}
