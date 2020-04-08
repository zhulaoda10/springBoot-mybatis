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
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		PageHelper.startPage(2, 2);
		List<User> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public User getUser(Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(@RequestBody User user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(@RequestBody User user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
    
    @RequestMapping(value="getOne")
    public Result<?> getOne(Long id ) {
    	Result<?> result = userService.getOne(id);
    	return result;
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