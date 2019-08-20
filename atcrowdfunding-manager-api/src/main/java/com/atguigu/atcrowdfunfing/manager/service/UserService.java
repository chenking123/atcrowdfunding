package com.atguigu.atcrowdfunfing.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunfing.bean.User;

public interface UserService {

	User queryUserlogin(Map<String, Object> paramMap);
}
