package com.example.demo.dao;


import com.example.demo.entity.PO.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zhangjingqi
 * @date 2024/03/03
 */
@Mapper
public interface UserMapper {


	/**
	 * 注册时添加User
	 * @param userPO User信息对象
	 * @return 插入影响的行数
	 */
	int saveUser(UserPO userPO);








	/**
	 * 通过phone查用户
	 * @param phone 用户手机号
	 * @return
	 */
	UserPO findUserByPhone(String phone);

	/**
	 * 通过userName查用户
	 * @param username 用户名
	 * @return
	 */
	UserPO findUserByUsername(String username);


	/**
	 * 通过userId查用户
	 * @param userId
	 * @return
	 */
	UserPO findUserByUserId(Integer userId);

	/**
	 * 更新用户信息
	 * @param user
	 * @return 更新影响的行数
	 */
	int updateUser(UserPO user);


}
