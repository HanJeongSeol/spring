package com.spring.biz.user;

import java.util.List;

public interface UserService {
	int insertUser();
	UserVO getUser(UserVO vo);
	List<UserVO> getUserList();
	int deleteUser();
}
