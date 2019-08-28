package cn.nuc.dao;

import java.util.List;

import cn.nuc.entity.Home;

/**
 * 关联类
 * @author 黄华飞
 *
 */
public interface UserHomeDao {
	/**
	 * 根据用户组主键，删除用户组与驴舍之间的关联关系
	 * @param groupId 用户组主键
	 * @return 影响行数
	 */
	int deleteByHomeId(Long HomeId);
	
	/**
	 * 批量新增
	 * @param list
	 * @return 影响行数
	 */
	int insertBatch(List<Home> list);

	int count();
}
