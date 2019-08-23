package junit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.MD5Util;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring*.xml");
		UserService userService=ac.getBean(UserService.class);
		for (int i =30;i<=50;i++) {
			User user =new User();
			user.setLoginacct("test"+i);
			user.setUserpswd(MD5Util.digest("123456"));
			user.setUsername("test"+i);
			user.setCreatetime("2019-8-23 11:17:00");
			user.setEmail("test"+i+"@cyh.com");
			userService.saveUser(user);
		}
		
		
	}
	
}