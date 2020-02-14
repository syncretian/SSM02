package com.services.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.model.User;
import com.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	UserMapper usermapper; 

	
	public User selectOne(User user) {
		User user1 = usermapper.selectOne(user);
		return user1;
		
	}
	

}
