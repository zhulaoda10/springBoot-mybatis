package com.neo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.Result;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	

	@Override
	public Result<?> userAgreement() {
		Result<String> result = new Result<String>();
		String userAgreementUrl = userMapper.getUserAgreementUrl();
		result.setData(userAgreementUrl);
		return result;
	}

	@Override
	public Result<User> getOne(Long id) {
		Result<User> result=new Result<User>();
		User user = userMapper.getOne(id);
		result.setData(user);
		return result;
	}
   
}
