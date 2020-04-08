package com.neo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.neo.model.User;
import com.neo.model.UserAgreement;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhuyf
 * @since 2020-04-02
 */
public interface UserMapper extends BaseMapper<User> {
	//用户协议url
	UserAgreement getUserAgreementUrl();
	
	//新增一条数据
	Boolean save(User user);
}
