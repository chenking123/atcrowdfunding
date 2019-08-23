package com.atguigu.atcrowdfunfing.manager.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunfing.bean.Role;
import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.util.Page;
import com.atguigu.atcrowdfunfing.vo.Data;

public interface UserService {

	User queryUserlogin(Map<String, Object> paramMap);

	//Page queryPage(Integer pageno, Integer pagesize);
	
	int saveUser(User user);

	Page queryPage(Map<String,Object> paramMap);

	User getUserById(Integer id);

	int updateUser(User user);

	int deleteUser(Integer id);

	int deleteBeachUser(Integer[] ids);

	int deleteBeachUserByVo(Data data);

	List<Role> querAllRole();

	List<Integer> queryRoleById(Integer id);

	int saveUserRoleRelationship(Integer userid, Data data);

	int deleteUserRoleRelationship(Integer userid, Data data);
}
