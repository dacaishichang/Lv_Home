package cn.nuc.service;

import java.util.List;

import cn.nuc.dto.HomeDto;

public interface HomeService {

//增删改查驴舍
//统计功能
//驴舍控制信息
	/**
	 * 新增驴舍
	 * @param userDto
	 * @return true:新增成功;false:因已存在相同用户名新增失败
	 */
	boolean add(HomeDto homeDto);
	
	/**
	 * 删除用户
	 * @param id
	 * @return true:删除成功;false:删除失败
	 */
	boolean remove(Long homeid);
	
	/**
	 * 通过id获取用户
	 * @param id
	 * @return 用户对象
	 */

	HomeDto getById(Long homeid);


	/**
	 * 修改驴舍
	 * @param homeDto
	 * @return true:修改成功;false:因已存在相同的用户名修改失败
	 */
	boolean modify(HomeDto homeDto);


	/**
	 * 通过id获取驴舍列表
	 * @param id
	 * @return 用户对象
	 */
	List<HomeDto> getByUserId(Long Userid);
	
	/**
	 * 通过获得所有Home
	 * @param id
	 * @return 用户对象
	 */
	List<HomeDto> getList(HomeDto homedto);

	int selectCount();

}
