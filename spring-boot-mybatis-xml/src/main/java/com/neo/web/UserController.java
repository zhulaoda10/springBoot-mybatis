package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.Result;

@RestController
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUsers")
	public Result<List<User>> getUsers() {
		PageHelper.startPage(2, 2);
		Result<List<User>> users=userService.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public Result<User> getUser(Long id) {
    	Result<User> user = userService.getUser(id);
        return user;
    }
    
    @RequestMapping("/add")
    public Result<User> save(@RequestBody User user) {
    	Result<User> result = userService.insert(user);
    	return result;
    }
    
    @RequestMapping(value="update")
    public Result<User> update(@RequestBody User user) {
    	Result<User> update = userService.update(user);
    	return update;
    }
    
    @RequestMapping(value="/delete/{id}")
    public Result<User> delete(@PathVariable("id") Long id) {
    	Result<User> delete = userService.delete(id);
    	return delete;
    }
    
    
    /**
     * 用户协议接口
     */
    @RequestMapping("agreement")
    public Result userAgreement() {
    
    	 Result<?> userAgreement = userService.userAgreement();
	
		return userAgreement;
    }
}