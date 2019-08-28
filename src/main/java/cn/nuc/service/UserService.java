package cn.nuc.service;

import java.util.List;

import cn.nuc.dto.UserDto;
import cn.nuc.entity.User;
/**
 * 高级功能
 * @author 黄华飞
 *
 */


public interface UserService {

	/**
	 * 校验用户名/密码是否正确
	 * @param userDto 待校验dto对象
	 * @return true：用户名/密码正确，如果正确，将dto对象里其他属性补齐
	 *                false：用户名/密码错误
	 */
	boolean validate(UserDto userDto);
	
	/**
	 * 获取用户列表
	 * @return 用户列表
	 */
	List<UserDto> getList(UserDto userDto);
	
	/**
	 * 修改用户
	 * @param userDto
	 * @return true:修改成功;false:因已存在相同的用户名修改失败
	 */
	boolean modify(UserDto userDto);
	
	/**
	 * 新增用户
	 * @param userDto
	 * @return true:新增成功;false:因已存在相同用户名新增失败
	 */
	boolean add(UserDto userDto);
	
	/**
	 * 删除用户
	 * @param id
	 * @return true:删除成功;false:删除失败
	 */
	boolean remove(Long id);
	
	/**
	 * 通过id获取用户
	 * @param id
	 * @return 用户对象
	 */
	UserDto getById(Long id);

	int selectCount();
}

