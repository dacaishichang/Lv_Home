package cn.nuc.service;

import java.util.List;

import cn.nuc.dto.DonkeyDto;


public interface DonkeyService {
	/**
     * 新增
     * @param action
     * @return 影响行数
     */
	boolean add(DonkeyDto donkeyDto);
    
    /**
	 * 删除用户
	 * @param id
	 * @return true:删除成功;false:删除失败
	 */
	boolean remove(Long donkeyid);
	
	/**
	 * 通过id获取用户
	 * @param id
	 * @return 用户对象
	 */
	DonkeyDto getById(Long donkeyid);
	
	/**
	 * 通过id获取驴舍列表
	 * @param id
	 * @return 用户对象
	 */
	List<DonkeyDto> getByDonkeyId(Long homeId);
    
	/**
	 * 通过获得所有donkey
	 * @param id
	 * @return 用户对象
	 */
	List<DonkeyDto> getList(DonkeyDto donkeyDto);

	/**
	 * 修改donkey
	 * @param id
	 * @return donkey对象
	 */
	boolean modify(DonkeyDto donkeyDto);


	int selectCount();
}
