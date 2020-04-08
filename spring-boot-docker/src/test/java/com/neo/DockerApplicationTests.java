package com.neo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neo.model.User;
import com.neo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerApplicationTests {

	/*
	 * @Test public void contextLoads() { System.out.println("hello docker"); }
	 */
   
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads1() {

		
		 // 所有用户 
		/*
		 * List<User> users = userService.selectList(new
		 * EntityWrapper<User>().where("id=1")); System.out.println(users);
		 */
		
    
		
		//更新
		/*
		 * User user = userService.selectById(5); user.setName("张三2"); boolean b =
		 * userService.updateById(user); System.out.println("==============="+b);
		 */
		
		//添加用户  自带的bug
		/*
		 * User user = new User(); user.setName("赵六"); user.setId(6); boolean insert =
		 * userService.insert(user); System.out.println("==============="+insert);
		 */
		
		//分页
		Page<User> selectPage = userService.selectPage(new Page<>(2,1),new EntityWrapper<User>().where("id>1"));
		List<User> records = selectPage.getRecords();
		System.out.println(records);
	}
	
	
	


}
