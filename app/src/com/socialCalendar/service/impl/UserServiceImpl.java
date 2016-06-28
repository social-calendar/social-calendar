package com.socialCalendar.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.socialCalendar.dao.UserDao;
import com.socialCalendar.pojo.User;
import com.socialCalendar.service.UserService;
/**
 * UserService实现类
 * @author NumberSevens
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User findByUserIdUser(Integer id) {
		return userDao.findByUserIdUser(id);
	}

	@Override
	public User findByOpenIdUser(String openID) {
		return userDao.findByOpenIdUser(openID);
	}
	 /**
     * 根据用户user_nickName查询
     * @param 
     * @return 用户集 
     */
	public List<User> findByNickNameUser(Map<String, Object> map) {
		return userDao.findByNickNameUser(map);
	}

	@Override
	public User saveOrUpdate(JSONObject wxUserInfo) {
		User user = new User();
		user.setOpenID(wxUserInfo.getString("openid"));
		user.setNickname(wxUserInfo.getString("nickname"));
		user.setSex(wxUserInfo.getInt("sex"));
		user.setHeadimgurl(wxUserInfo.getString("headimgurl"));
		if(userDao.findByOpenIdUser(user.getOpenID())!=null){
			User u = userDao.findByOpenIdUser(user.getOpenID());
			user.setId(u.getId());
			userDao.updateUser(user);//数据库有用户信息则跟新
		}else{
			userDao.addUser(user);//如果数据库没有则添加
		}
		System.out.println(user);
		return user;
	}
}
