package com.atguigu.atcrowdfunfing.manager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.Page;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index.do")
	public String index(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize, Map map) {

		Page page = userService.queryPage(pageno, pagesize);

		map.put("page", page);

		return "user/index";
	}

}
