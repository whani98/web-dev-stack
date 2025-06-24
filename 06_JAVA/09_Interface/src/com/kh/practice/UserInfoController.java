package com.kh.practice;

import com.kh.practice.model.UserInfo;

public class UserInfoController {
	
	private UserInfo[] userInfo = new UserInfo[1];

	public UserInfo[] getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo[] userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
