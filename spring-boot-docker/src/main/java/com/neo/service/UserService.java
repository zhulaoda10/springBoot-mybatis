package com.neo.service;

import com.neo.model.User;
import com.neo.util.Result;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhuyf
 * @since 2020-04-02
 */
public interface UserService extends IService<User> {

	Result<?> getOne(Long id);

	Result<?> userAgreement();
	
	Result<?> save(User user);

}
