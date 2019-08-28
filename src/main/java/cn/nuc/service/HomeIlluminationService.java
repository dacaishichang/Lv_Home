package cn.nuc.service;

import cn.nuc.dto.IlluminationDto;
import java.util.List;

public interface HomeIlluminationService {
    /**
     * 新增驴舍
     * @param userDto
     * @return true:新增成功;false:因已存在相同用户名新增失败
     */
    boolean add(IlluminationDto illuminationDto);

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

    IlluminationDto getById(Long hometimeId);


    /**
     * 修改驴舍
     * @param homeDto
     * @return true:修改成功;false:因已存在相同的用户名修改失败
     */
    boolean modify(IlluminationDto illuminationDto);


    /**
     * 通过id获取驴舍列表
     * @param id
     * @return 用户对象
     */
    List<IlluminationDto> getByHomeId(Long HomeId);

    /**
     * 通过获得所有Home
     * @param id
     * @return 用户对象
     */
    List<IlluminationDto> getList(IlluminationDto illuminationDto);

    int selectCount(Long homeId);
}
