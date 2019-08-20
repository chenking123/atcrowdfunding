package com.atguigu.atcrowdfunfing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.Const;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index.htm")
	public String index() {
		return "index";
	}

	@RequestMapping("/login.htm")
	public String login() {
		return "login";
	}

	@RequestMapping("/reg.htm")
	public String reg() {
		return "reg";
	}

	@RequestMapping("/dologin.do")
	public String doLogin(String loginacct, String userpswd, String type, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginacct", loginacct);
		paramMap.put("userpswd", userpswd);
		paramMap.put("type", type);

		User user = userService.queryUserlogin(paramMap);
		session.setAttribute(Const.LOGIN_USER, user);
		
		return "redirect:main.htm";
	}
	
	@RequestMapping("/main.htm")
	public String main() {
		return "main";
	}
}
