package com.neo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neo.exception.RequestException;
import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.ResponseCode;
import com.neo.util.Result;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	

	@Override
	public Result<String> userAgreement() {
		Result<String> result = new Result<String>();
		String userAgreementUrl = userMapper.getUserAgreementUrl();
		result.setData(userAgreementUrl);
		return result;
	}
    
	//查询数据库后 数据添加到缓存
    @Cacheable(cacheNames = "cacheManager", key = "'USER:'+#id", unless = "#result == null")
	@Override
	public Result<User> getUser(Long id) {
		Result<User> result=new Result<User>();
		User user = userMapper.getOne(id);
		result.setData(user);
		return result;
	}

	@Override
	public Result<List<User>> getAll() {
		Result<List<User>> result=new Result<List<User>>();
		List<User> all = userMapper.getAll();
		result.setData(all);
		return result;
	}

	@Override
	public Result<User> insert(User user) {
		Result<User> result=new Result<User>();
		userMapper.insert(user);
		result.setMsg("插入成功");
		result.setData(user);
		return result;
	}

    //修改数据后更新缓存
    @Override
    @CachePut(cacheNames = "cacheManager", key = "'USER:'+#user.id", unless = "#result == null")
	public Result<User> update(User user) {
		Result<User> result=new Result<User>();
		User updateuser = userMapper.getOne(user.getId());
		if(updateuser!=null) {
			userMapper.update(user);

			result.setMsg("修改成功");
			result.setData(updateuser);
			return result;
		}else {
			 throw new RequestException(ResponseCode.FAIL);
		}
		
	}

	//清除一条缓存，key为要清空的数据
    @Override
    @CacheEvict(cacheNames = "cacheManager", key = "'USER:'+#id")
	public Result<User> delete(Long id) {
		Result<User> result=new Result<User>();
		userMapper.delete(id);
		result.setMsg("删除成功");
		return result;
	}
   
}
