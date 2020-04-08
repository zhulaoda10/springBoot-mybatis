package com.neo.service.impl;

import com.neo.model.User;
import com.neo.model.UserAgreement;
import com.neo.mapper.UserMapper;
import com.neo.service.UserService;
import com.neo.util.Result;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhuyf
 * @since 2020-04-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
  
	@Override
	public Result<?> getOne(Long id) {
		User user = baseMapper.selectById(id);
		Result<User> result = new Result<User>();
		result.setData(user);
		return result;
	}


	@Override
	public Result<?> userAgreement() {
		 UserAgreement userAgreementUrl = baseMapper.getUserAgreementUrl();
		Result<UserAgreement> result = new Result<UserAgreement>();
		result.setData(userAgreementUrl);
		return result;
	}


	@Override
	public Result<?> save(User user) {
		Result result = new Result();
		Boolean save = baseMapper.save(user);
		if(save) {
			result.setMsg("成功");
		}else {
			result.setMsg("失败");
		}
		
		return result;
	}

}
