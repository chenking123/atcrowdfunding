package com.atguigu.atcrowdfunfing.listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.atcrowdfunfing.bean.Permission;
import com.atguigu.atcrowdfunfing.manager.service.PermissionService;
import com.atguigu.atcrowdfunfing.util.Const;

public class StartSystemListener implements ServletContextListener {

	
	// 在服务器启动时，创建application对象时需要执行的方法
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 将项目上下文路径(request.getContextPath())放置到application域中
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		application.setAttribute("APP_PATH", contextPath);
		System.out.println(contextPath);
		
		ApplicationContext ioc=WebApplicationContextUtils.getWebApplicationContext(application);
		
		PermissionService permissionService=ioc.getBean(PermissionService.class);
		
		List<Permission> queryAllPermission = permissionService.queryAllPermission();

		Set<String> allURIs = new HashSet<String>();

		for (Permission permission : queryAllPermission) {
			allURIs.add("/" + permission.getUrl());
		}
		
		application.setAttribute(Const.ALL_PERMISSION_URI, allURIs);
		
	}

}
