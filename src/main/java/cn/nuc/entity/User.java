package cn.nuc.entity;

import java.util.List;

/**
 * 用户类
 * @author 黄华飞
 *
 */
public class User {
	public Long userId;
	public String useraccount;
	public String username;
	public String password;
	public String sex;
	public Long age;
	
	public List<Home> homeList;

	
	public final String getUseraccount() {
		return useraccount;
	}
	public final void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public final List<Home> getHomeList() {
		return homeList;
	}
	public final void setHomeList(List<Home> homeList) {
		this.homeList = homeList;
	}
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	
	public final Long getUserId() {
		return userId;
	}
	public final void setUserId(Long userId) {
		this.userId = userId;
	}
	public final String getSex() {
		return sex;
	}
	public final void setSex(String sex) {
		this.sex = sex;
	}
	public final Long getAge() {
		return age;
	}
	public final void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+userId+","+username+","+age+"]";
	}
}
