package cn.nuc.dao;

import java.util.List;

import cn.nuc.entity.Donkey;
import cn.nuc.entity.Home;

/**
 * 增删改查，统计数据，统计数据
 * @author 黄华飞
 *
 */
public interface DonkeyDao {
	
	/**
     * 根据查询条件查询用户列表
     * @param user 查询条件
     * @return 用户列表
     */
    List<Donkey> select(Donkey donkey);
	
	/**
     * 新增
     * @param action
     * @return 影响行数
     */
    int insert(Donkey donkey);
    
    /**
     * 修改
     * @param action
     * @return 影响行数
     */
    int update(Donkey donkey);
    
    /**
     * 根据主键获取动作实体
     * @param id 主键
     * @return 动作实体
     */
    Donkey selectById(Long id);
    
    /**
	 * 根据用户ID删除动作
	 * @param menuId 菜单ID
	 * @return 影响行数
	 */
	int deleteByHomeId(Long homeId);
	
	/**
	 * 根据主键删除动作
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);


	int count();
}
