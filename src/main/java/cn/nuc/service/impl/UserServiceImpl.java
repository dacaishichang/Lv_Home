package cn.nuc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nuc.dao.UserDao;
import cn.nuc.dto.UserDto;
import cn.nuc.entity.User;
import cn.nuc.service.UserService;
import cn.nuc.util.MD5Util;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	//登录验证用
	public boolean validate(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		List<User> list = userDao.select(user);
		if(list.size()==1){
			return true;
		}
		return false;
	}

	@Override
	public List<UserDto> getList(UserDto userDto) {
		List<UserDto> result = new ArrayList<>();
		System.out.println(userDto.getLimit()+":"+userDto.getPage());
		List<User> userList = userDao.select(userDto);
		for (User user : userList) {
			UserDto userDto_ = new UserDto();
			result.add(userDto_);
			//字段赋值，常用于类赋值
			BeanUtils.copyProperties(user, userDto_);
			userDto.setpId(0);
		}
		return result;
	}

	@Override
	public boolean modify(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
//		if(!CommonUtil.isEmpty(userDto.getPassword())) {
//			user.setPassword(MD5Util.getMD5(userDto.getPassword()));
//		}
		return userDao.update(user) == 1;
	}

	@Override
	public boolean add(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		System.out.println(userDto);
//		user.setPassword(MD5Util.getMD5(userDto.getPassword()));
		return userDao.insert(user) == 1;
	}

	@Override
	public boolean remove(Long id) {
		return userDao.delete(id) == 1;
	}

	@Override
	public UserDto getById(Long id) {
		UserDto userDto = new UserDto();
		User user = userDao.selectById(id);
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public int selectCount() {
		return userDao.count();
	}

}
