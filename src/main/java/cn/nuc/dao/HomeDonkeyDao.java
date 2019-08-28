package cn.nuc.dao;

import java.util.List;

import cn.nuc.entity.Donkey;

/**
 * 关联类匹配
 * @author 黄华飞
 *
 */
public interface HomeDonkeyDao {
	/**
	 * 根据用户组主键，删除用户组与驴舍之间的关联关系
	 * @param groupId 用户组主键
	 * @return 影响行数
	 */
	int deleteByDonkeyId(Long donkeyId);
	
	/**
	 * 批量新增
	 * @param list
	 * @return 影响行数
	 */
	int insertBatch(List<Donkey> list);

	int count();
}
