package cn.nuc.dao;

import java.util.List;

import cn.nuc.entity.User;
/**
 * 添加用户，增删改查，显示全部，统计数据
 * @author 黄华飞
 *
 */
public interface UserDao {


    /**
     * 根据查询条件查询用户列表
     * @param user 查询条件
     * @return 用户列表
     */
    List<User> select(User userDto);
    
    /**
     * 新增
     * @param user
     * @return 影响行数：如果用户名已存在，影响行数为0，新增成功，影响行数为1
     */
    Long insert(User user);
    
    /**
     * 根据主键获取用户实体
     * @param id 主键
     * @return 用户实体
     */
    User selectById(Long id);
    
    /**
     * 修改
     * @param user
     * @return 影响行数：如用户名将修改成与其他用户的用户名相同，影响行数为0，修改成功，影响行数为1
     */
    Long update(User user);
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    Long delete(Long id);

    int count();
	
	
}
