package cn.nuc.service.impl;

import cn.nuc.dao.DonkeyHistoryDao;
import cn.nuc.dao.IlluminationDao;
import cn.nuc.dto.HumidityDto;
import cn.nuc.dto.IlluminationDto;
import cn.nuc.entity.HomeHumidityHistory;
import cn.nuc.entity.HomeIlluminationHistory;
import cn.nuc.service.HomeIlluminationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeIlluminationServiceImpl implements HomeIlluminationService {

    @Autowired
    private IlluminationDao illuminationDao;

    @Override
    public boolean add(IlluminationDto illuminationDto) {
        return false;
    }

    @Override
    public boolean remove(Long hometimeId) {
        return false;
    }

    @Override
    public IlluminationDto getById(Long hometimeId) {
        return null;
    }

    @Override
    public boolean modify(IlluminationDto illuminationDto) {
        return false;
    }

    @Override
    public List<IlluminationDto> getByHomeId(Long homeId) {
        List<IlluminationDto> result = new ArrayList<>();
        IlluminationDto temp = new IlluminationDto();
        temp.setHomeId(homeId);
        List<HomeIlluminationHistory> homeIlluminationHistoryList = illuminationDao.select(temp);
        for (HomeIlluminationHistory homeIlluminationHistory : homeIlluminationHistoryList) {
            IlluminationDto illuminationDto = new IlluminationDto();
            result.add(illuminationDto);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeIlluminationHistory, illuminationDto);
            illuminationDto.setpId(0);
        }
        return result;
    }

    @Override
    public List<IlluminationDto> getList(IlluminationDto illuminationDto) {
        List<IlluminationDto> result = new ArrayList<>();
        List<HomeIlluminationHistory> homeIlluminationHistoryList = illuminationDao.select(illuminationDto);
        for (HomeIlluminationHistory homeIlluminationHistory : homeIlluminationHistoryList) {
            IlluminationDto illuminationDto_ = new IlluminationDto();
            result.add(illuminationDto_);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeIlluminationHistory, illuminationDto_);
            illuminationDto.setpId(0);
        }
        return result;
    }

    @Override
    public int selectCount(Long homeId) {
        return illuminationDao.count(homeId);
    }
}
