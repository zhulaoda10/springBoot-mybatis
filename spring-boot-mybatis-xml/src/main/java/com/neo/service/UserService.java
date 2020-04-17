package com.neo.service;

import java.util.List;

import com.neo.model.User;
import com.neo.util.Result;

public interface UserService {
	//获取用户协议url
   public Result<String> userAgreement();
   
   
   public Result<User> getUser(Long id);
   
   
   public Result<List<User>> getAll();
   
   
   public Result<User> insert(User user);
   
   
   public Result<User> update(User user);
   
   public Result<User> delete(Long id);
}
