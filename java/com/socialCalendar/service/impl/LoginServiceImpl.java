package com.socialCalendar.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.socialCalendar.dao.UserDao;
import com.socialCalendar.service.LoginService;


@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private UserDao userDao;

	@Override
	public int login() {
		return 0;
	}

}
