package cn.nuc.service;

import cn.nuc.dto.DonkeyHistoryDto;


import java.util.List;

public interface DonkeyHistoryService {
    /**
     * 新增驴舍
     * @param userDto
     * @return true:新增成功;false:因已存在相同用户名新增失败
     */
    boolean add(DonkeyHistoryDto donkeyHistoryDto);

    /**
     * 删除用户
     * @param id
     * @return true:删除成功;false:删除失败
     */
    boolean remove(Long hometimeId);

    /**
     * 通过id获取用户
     * @param id
     * @return 用户对象
     */

    DonkeyHistoryDto getById(Long hometimeId);


    /**
     * 修改驴舍
     * @param homeDto
     * @return true:修改成功;false:因已存在相同的用户名修改失败
     */
    boolean modify(DonkeyHistoryDto donkeyHistoryDto);


    /**
     * 通过id获取驴舍列表
     * @param id
     * @return 用户对象
     */
    List<DonkeyHistoryDto> getByDonkeyId(DonkeyHistoryDto donkeyHistoryDto);

    /**
     * 通过获得所有Home
     * @param id
     * @return 用户对象
     */
    List<DonkeyHistoryDto> getList(DonkeyHistoryDto donkeyHistoryDto);


    int selectCount();
}
