package com.neo.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.Result;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhuyf
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
    
	@RequestMapping("show")
    public Result<?>  getOne(Long id ) {
    	Result<?> result = userService.getOne(id);
//    	User selectById = userService.selectById(2);
//    	Result result=new Result();
//    	result.setData(selectById);
    	return result;
    }
	
	
	@RequestMapping("getAll")
    public Result<?>  getAll() {
    	List<User> selectList = userService.selectList(null);
     	Result result=new Result();
    	result.setData(selectList);
    	return result;
    }
	
	@RequestMapping("save")
    public Result<?> save(@RequestBody User user ) {
		/*
		 * Result result=new Result(); user.setId(1); user.setName("aaa"); boolean
		 * insert = userService.insertAllColumn(user);
		 */
		
		Result<?> save = userService.save(user);
    	return save;
    }
	  /**
     * 用户协议接口
     */
    @RequestMapping("agreement")
    public Result<?> userAgreement() {
    	Result<?> userAgreement = userService.userAgreement();
		return userAgreement;
    }
}

