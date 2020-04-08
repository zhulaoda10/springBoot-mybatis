package com.neo.service;

import com.neo.util.Result;

public interface UserService {
	//获取用户协议url
   public Result<?> userAgreement();
   
   
   public Result<?> getOne(Long id);
}
