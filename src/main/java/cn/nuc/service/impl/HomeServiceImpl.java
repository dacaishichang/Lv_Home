package cn.nuc.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nuc.dao.HomeDao;
import cn.nuc.dto.HomeDto;
import cn.nuc.dto.UserDto;
import cn.nuc.entity.Home;
import cn.nuc.entity.User;
import cn.nuc.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;
	
	@Override
	public boolean add(HomeDto homeDto) {
		Home home = new Home();
		BeanUtils.copyProperties(homeDto, home);
		System.out.println(home);
		return homeDao.insert(home) == 1;
	}

	/**
	 * 删除驴舍
	 */
	@Override
	public boolean remove(Long homeId) {
		return homeDao.deleteById(homeId) == 1;
	}
	
	/**
	 * 获得驴舍
	 */
	@Override
	public HomeDto getById(Long homeId) {
		HomeDto homeDto = new HomeDto();
		Home home = homeDao.selectById(homeId);
		BeanUtils.copyProperties(home, homeDto);
		return homeDto;
	}

	@Override
	public boolean modify(HomeDto homeDto) {
		Home home=new Home();
		BeanUtils.copyProperties(homeDto, home);
		return homeDao.update(home) == 1;
	}

	/**
	 * 获得驴舍（通过用户ID）
	 */
	@Override
	public List<HomeDto> getByUserId(Long homeId) {
		List<HomeDto> result = new ArrayList<>();
		List<Home> homeList = homeDao.select(new Home());
		for (Home home : homeList) {
			HomeDto homeDto = new HomeDto();
			result.add(homeDto);
			//字段赋值，常用于类赋值
			BeanUtils.copyProperties(home, homeDto);
			homeDto.setpId(0);
		}
		return result;
	}

	
	@Override
	public List<HomeDto> getList(HomeDto homeDto) {
		List<HomeDto> result = new ArrayList<>();
		List<Home> homeList = homeDao.select(homeDto);
		for (Home home : homeList) {
			HomeDto homeDto_ = new HomeDto();
			result.add(homeDto_);
			//字段赋值，常用于类赋值
			BeanUtils.copyProperties(home, homeDto_);
			homeDto.setpId(0);
		}
		return result;
	}

	@Override
	public int selectCount() {
		return homeDao.count();
	}
}
