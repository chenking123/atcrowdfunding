package com.atguigu.atcrowdfunfing.manager.dao;

import com.atguigu.atcrowdfunfing.bean.Permission;
import com.atguigu.atcrowdfunfing.bean.Role;
import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.bean.UserExample;
import com.atguigu.atcrowdfunfing.vo.Data;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User queryUserlogin(Map<String, Object> paramMap);

	// List<User> querList(@Param("startIndex")Integer startIndex,@Param("pagesize")
	// Integer pagesize);

	// Integer queryCount();

	List<User> querList(Map<String, Object> paramMap);

	Integer queryCount(Map<String, Object> paramMap);

	int deleteBeachUserByVo(Data data);

	List<Role> querAllRole();

	List<Integer> queryRoleById(Integer id);

	int saveUserRoleRelationship(@Param("userid") Integer userid, @Param("data") Data data);

	int deleteUserRoleRelationship(@Param("userid") Integer userid, @Param("data") Data data);

	List<Permission> queryPermissionByUserid(Integer id);
}