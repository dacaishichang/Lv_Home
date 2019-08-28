package cn.nuc.dao;

import java.util.List;

import cn.nuc.entity.Home;
//
/**
 * 增删改查，显示全部，统计数据
 * @author 黄华飞
 *
 */
public interface HomeDao {
	
	/**
     * 根据查询条件查询用户列表
     * @param user 查询条件
     * @return 用户列表
     */
    List<Home> select(Home home);
	/**
     * 新增
     * @param user
     * @return 影响行数：如果用户名已存在，影响行数为0，新增成功，影响行数为1
     */
	int insert(Home home);
    
    /**
     * 修改
     * @param action
     * @return 影响行数
     */
    int update(Home home);
    
    /**
     * 根据主键获取动作实体
     * @param id 主键
     * @return 动作实体
     */
    Home selectById(Long id);
    
    /**
	 * 根据用户ID删除动作
	 * @param menuId 菜单ID
	 * @return 影响行数
	 */
	int deleteByUserId(Long userId);
	
	/**
	 * 根据主键删除动作
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);

	int count();
}
