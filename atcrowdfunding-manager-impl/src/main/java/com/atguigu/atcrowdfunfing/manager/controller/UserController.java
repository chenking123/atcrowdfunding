package com.atguigu.atcrowdfunfing.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.AjaxResult;
import com.atguigu.atcrowdfunfing.util.Page;
import com.atguigu.atcrowdfunfing.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/toindex.htm")
	public String toindex() {

		return "user/index";
	}

	// 条件查询
	@RequestMapping("/index.do")
	@ResponseBody
	public Object index(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize,
			String queryText) {

		AjaxResult result = new AjaxResult();

		try {

			Map<String, Object> paramMap = new HashMap<String, Object>();

			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);

			if (StringUtil.isNotEmpty(queryText)) {
				if (queryText.contains("%")) {
					queryText.replaceAll("%", "\\\\%");
				}
				paramMap.put("queryText", queryText);
			}
			Page page = userService.queryPage(paramMap);
			result.setSuccess(true);
			result.setPage(page);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("查询数据失败");
		}
		return result;
	}

	/*
	 * @RequestMapping("/index.do") public String index(@RequestParam(value =
	 * "pageno", required = false, defaultValue = "1") Integer pageno,
	 * 
	 * @RequestParam(value = "pagesize", required = false, defaultValue = "10")
	 * Integer pagesize, Map map) {
	 * 
	 * Page page = userService.queryPage(pageno, pagesize);
	 * 
	 * map.put("page", page);
	 * 
	 * return "user/index"; }
	 */
	 
	@RequestMapping("/toAdd.htm")
	public String toAdd() {

		return "user/add";
	}
	
	@RequestMapping("/doAdd.do")
	@ResponseBody
	public Object doAdd(User user) {

		AjaxResult result = new AjaxResult();

		try {
			int count = userService.saveUser(user);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("新增数据失败");
		}
		return result;
	}
	
	@RequestMapping("/toUpdate.htm")
	public String toUpdate(Integer id,Map map) {
		User user=userService.getUserById(id);
		map.put("user", user);
		return "user/update";
	}
	
	
	@RequestMapping("/doUpdate.do")
	@ResponseBody
	public Object doUpdate(User user) {
		
		AjaxResult result = new AjaxResult();
		
		try {
			int count = userService.updateUser(user);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("修改数据失败");
		}
		return result;
	}
	
	@RequestMapping("/doDelete.do")
	@ResponseBody
	public Object doDelete(Integer id) {
		
		AjaxResult result = new AjaxResult();
		
		try {
			int count = userService.deleteUser(id);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除数据失败");
		}
		return result;
	}
	
	@RequestMapping("/doDeleteBeach.do")
	@ResponseBody
	public Object doDeleteBeach(Integer[] id) {
		
		AjaxResult result = new AjaxResult();
		
		try {
			int count = userService.deleteBeachUser(id);
			result.setSuccess(count==id.length);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除数据失败");
		}
		return result;
	}

}
