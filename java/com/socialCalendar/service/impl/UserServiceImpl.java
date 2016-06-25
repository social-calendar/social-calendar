package com.socialCalendar.service.impl;

import java.util.List;

import javax.annotation.Resource;

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

	public List<User> findByNickNameUser(String nickname) {
		return userDao.findByNickNameUser(nickname);
	}

}
