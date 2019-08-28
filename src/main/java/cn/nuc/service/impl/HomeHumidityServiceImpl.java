package cn.nuc.service.impl;

import cn.nuc.dao.HumidityDao;
import cn.nuc.dto.HumidityDto;
import cn.nuc.dto.HumidityDto;
import cn.nuc.dto.UserDto;
import cn.nuc.entity.DonkeyHistory;
import cn.nuc.entity.HomeHumidityHistory;
import cn.nuc.service.HomeHumidityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeHumidityServiceImpl implements HomeHumidityService {

    @Autowired
    private HumidityDao humidityDao;

    @Override
    public boolean add(HumidityDto humidityDto) {
        return false;
    }

    @Override
    public boolean remove(Long hometimeId) {
        return false;
    }

    @Override
    public HumidityDto getById(Long hometimeId) {
        return null;
    }

    @Override
    public boolean modify(HumidityDto humidityDto) {
        return false;
    }

    @Override
    public List<HumidityDto> getByHomeId(Long homeId) {
        List<HumidityDto> result = new ArrayList<>();
        HumidityDto temp = new HumidityDto();
        temp.setHomeId(homeId);
        List<HomeHumidityHistory> homeHumidityHistoryList = humidityDao.select(temp);
        for (HomeHumidityHistory homeHumidityHistory : homeHumidityHistoryList) {
            HumidityDto humidityDto = new HumidityDto();
            result.add(humidityDto);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeHumidityHistory, humidityDto);
            humidityDto.setpId(0);
        }
        return result;
    }

    @Override
    public List<HumidityDto> getList(HumidityDto humidityDto) {
        List<HumidityDto> result = new ArrayList<>();
        List<HomeHumidityHistory> homeHumidityHistoryList = humidityDao.select(humidityDto);
        for (HomeHumidityHistory homeHumidityHistory : homeHumidityHistoryList) {
            HumidityDto humidityDto_ = new HumidityDto();
            result.add(humidityDto_);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeHumidityHistory, humidityDto_);
            humidityDto.setpId(0);
        }
        return result;
    }

    @Override
    public int selectCount(Long homeId) {
        return humidityDao.count(homeId);
    }
}
