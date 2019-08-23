package com.atguigu.atcrowdfunfing.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunfing.bean.Role;
import com.atguigu.atcrowdfunfing.bean.User;
import com.atguigu.atcrowdfunfing.exception.LoginFailException;
import com.atguigu.atcrowdfunfing.manager.dao.UserMapper;
import com.atguigu.atcrowdfunfing.manager.service.UserService;
import com.atguigu.atcrowdfunfing.util.Const;
import com.atguigu.atcrowdfunfing.util.MD5Util;
import com.atguigu.atcrowdfunfing.util.Page;
import com.atguigu.atcrowdfunfing.vo.Data;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserlogin(Map<String, Object> paramMap) {
		User user = userMapper.queryUserlogin(paramMap);

		if (user == null) {
			throw new LoginFailException("用户账号或密码不正确");
		}

		return user;
	}

	/*@Override
	public Page queryPage(Integer pageno, Integer pagesize) {
		Page page = new Page(pageno, pagesize);

		Integer startIndex = page.getStartIndex();

		List<User> datas = userMapper.querList(startIndex, pagesize);

		page.setDatas(datas);

		Integer count = userMapper.queryCount();

		page.setTotalsize(count);

		return page;
	}*/

	@Override
	public int saveUser(User user) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =new Date();
		String createtime=sdf.format(date);
		user.setCreatetime(createtime);
		
		user.setUserpswd(MD5Util.digest(Const.PASSWORD));
		
		return userMapper.insert(user);
	}

	@Override
	public Page queryPage(Map<String,Object> paramMap) {
		Page page = new Page((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize") );

		Integer startIndex = page.getStartIndex();
		
		paramMap.put("startIndex", startIndex);

		List<User> datas = userMapper.querList(paramMap);

		page.setDatas(datas);

		Integer count = userMapper.queryCount(paramMap);

		page.setTotalsize(count);

		return page;
	}

	@Override
	public User getUserById(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteBeachUser(Integer[] ids) {
		int totalcount=0;
		for (Integer id : ids) {
			int count=userMapper.deleteByPrimaryKey(id);
			totalcount+=count;
		}
		if(totalcount!=ids.length) {
			throw new RuntimeException("批量删除失败");
		}
		return totalcount;
	}

	@Override
	public int deleteBeachUserByVo(Data data) {
		
		return userMapper.deleteBeachUserByVo(data);
	}

	@Override
	public List<Role> querAllRole() {
		// TODO Auto-generated method stub
		return userMapper.querAllRole();
	}

	@Override
	public List<Integer> queryRoleById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.queryRoleById(id);
	}

	@Override
	public int saveUserRoleRelationship(Integer userid, Data data) {
		// TODO Auto-generated method stub
		return userMapper.saveUserRoleRelationship(userid,data);
	}

	@Override
	public int deleteUserRoleRelationship(Integer userid, Data data) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserRoleRelationship(userid,data);
	}

}
