package cn.nuc.service;

import cn.nuc.dto.HumidityDto;
import cn.nuc.dto.TemperatureDto;

import java.util.List;

public interface HomeTemperatureService {
    /**
     * 新增驴舍
     * @param userDto
     * @return true:新增成功;false:因已存在相同用户名新增失败
     */
    boolean add(TemperatureDto temperatureDto);

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

    TemperatureDto getById(Long hometimeId);


    /**
     * 修改驴舍
     * @param homeDto
     * @return true:修改成功;false:因已存在相同的用户名修改失败
     */
    boolean modify(TemperatureDto temperatureDto);


    /**
     * 通过id获取驴舍列表
     * @param id
     * @return 用户对象
     */
    List<TemperatureDto> getByHomeId(Long HomeId);

    /**
     * 通过获得所有Home
     * @param id
     * @return 用户对象
     */
    List<TemperatureDto> getList(TemperatureDto temperatureDto);

    /**
     * 得到所有值的计数
     * @return
     */
    int selectCount(Long homeId);

}
