package com.atguigu.atcrowdfunfing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.AjaxResult;
import com.atguigu.atcrowdfunfing.util.Const;
import com.atguigu.atcrowdfunfing.util.MD5Util;

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

	// 异步请求
	// @ResponseBody 结合Jackson组件，将结果转换为字符串，将json串以流的形式返回客户端
	@RequestMapping("/dologin.do")
	@ResponseBody
	public Object doLogin(String loginacct, String userpswd, String type, HttpSession session) {

		AjaxResult result = new AjaxResult();

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", MD5Util.digest(userpswd));
			paramMap.put("type", type);

			User user = userService.queryUserlogin(paramMap);
			session.setAttribute(Const.LOGIN_USER, user);
			result.setSuccess(true);
			// {"result":"true"}
		} catch (Exception e) {
			result.setMessage("登陆失败");
			e.printStackTrace();
			result.setSuccess(false);
			// {"result":"false","message":"登陆失败"}
		}
		return result;
	}

	// 同步请求
	/*
	 * @RequestMapping("/dologin.do") public String doLogin(String loginacct, String
	 * userpswd, String type, HttpSession session) { Map<String, Object> paramMap =
	 * new HashMap<String, Object>(); paramMap.put("loginacct", loginacct);
	 * paramMap.put("userpswd", userpswd); paramMap.put("type", type);
	 * 
	 * User user = userService.queryUserlogin(paramMap);
	 * session.setAttribute(Const.LOGIN_USER, user);
	 * 
	 * return "redirect:main.htm"; }
	 */

	@RequestMapping("/main.htm")
	public String main() {
		return "main";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();//销毁session对象
		return "redirect:index.htm";
	}
}
