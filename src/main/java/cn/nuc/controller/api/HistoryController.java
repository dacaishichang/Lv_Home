package cn.nuc.controller.api;

import cn.nuc.dao.DonkeyHistoryDao;
import cn.nuc.dto.*;
import cn.nuc.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/history")
public class HistoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DonkeyHistoryService donkeyHistoryService;

    @Autowired
    private HomeHumidityService homeHumidityService;

    @Autowired
    private HomeTemperatureService homeTemperatureService;

    @Autowired
    private HomeIlluminationService homeIlluminationService;

// -----------------------------驴刷卡----------------------------------
    /**
     * 查询所有驴的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listDonkeyHistory", method = RequestMethod.GET)
    private ResponseObject<List<DonkeyHistoryDto>> listDonkeyHistory(@RequestParam(value="page",defaultValue="1",required=true) int page
            , @RequestParam(value="limit",defaultValue="100",required=true) int limit
            , @RequestParam(value="donkeyId",defaultValue="-1",required=true) Long donkeyId){
        System.out.println("listDonkeyHistory");
        DonkeyHistoryDto donkeyHistoryDto = new DonkeyHistoryDto();
        donkeyHistoryDto.setLimit(limit);
        donkeyHistoryDto.setPage(page);
        donkeyId=donkeyId==-1?null:donkeyId;
        donkeyHistoryDto.setDonkeyId(donkeyId);
        ResponseObject<List<DonkeyHistoryDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(donkeyHistoryService.getList(donkeyHistoryDto));
        responseObject.setCount(donkeyHistoryService.selectCount());
        return responseObject;
    }

    /**
     * 查询指定驴的刷卡的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listDonkeyHistoryByDonkeyId/{donkeyId}", method = RequestMethod.GET)
    private ResponseObject<List<DonkeyHistoryDto>> listDonkeyHistoryByDonkeyId(@RequestParam(value="page",defaultValue="1",required=true) int page
            , @RequestParam(value="limit",defaultValue="100",required=true) int limit
            , @RequestParam(value="donkeyId",defaultValue="1",required=true) long donkeyId){
        System.out.println("listDonkeyHistoryByDonkeyId");
        DonkeyHistoryDto donkeyHistoryDto = new DonkeyHistoryDto();
        donkeyHistoryDto.setLimit(limit);
        donkeyHistoryDto.setPage(page);
        donkeyHistoryDto.setDonkeyId(donkeyId);
        ResponseObject<List<DonkeyHistoryDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(donkeyHistoryService.getByDonkeyId(donkeyHistoryDto));
        responseObject.setCount(donkeyHistoryService.selectCount());
        return responseObject;
    }

// ----------------------------------湿度-----------------------------
    /**
     * 查询所有湿度的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listHumidityHistory", method = RequestMethod.GET)
    private ResponseObject<List<HumidityDto>> listHumidityHistory(@RequestParam(value="page",defaultValue="1",required=true) int page
            , @RequestParam(value="limit",defaultValue="100",required=true) int limit
            , @RequestParam(value="homeId",defaultValue="1",required=true) long homeId){
        System.out.println("listHumidityHistory");
        HumidityDto humidityDto = new HumidityDto();
        humidityDto.setLimit(limit);
        humidityDto.setPage(page);
        humidityDto.setHomeId(homeId);
        ResponseObject<List<HumidityDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeHumidityService.getList(humidityDto));
        responseObject.setCount(homeHumidityService.selectCount(homeId));
        return responseObject;
    }

    /**
     * 查询指定驴舍的湿度的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listHumidityHistoryByHomeId/{homeId}", method = RequestMethod.GET)
    private ResponseObject<List<HumidityDto>> listHumidityHistoryByHomeId(@PathVariable Long homeId){
        System.out.println("listHumidityHistory");
        ResponseObject<List<HumidityDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeHumidityService.getByHomeId(homeId));
        responseObject.setCount(homeHumidityService.selectCount(homeId));
        return responseObject;
    }


// -------------------------------------光照--------------------------

    /**
     * 查询所有光照的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listIlluminationHistory", method = RequestMethod.GET)
    private ResponseObject<List<IlluminationDto>> listIlluminationHistory(@RequestParam(value="page",defaultValue="1",required=true) int page
            , @RequestParam(value="limit",defaultValue="100",required=true) int limit
            , @RequestParam(value="homeId",defaultValue="1",required=true) long homeId){
        System.out.println("listIlluminationHistory");
        IlluminationDto illuminationDto = new IlluminationDto();
        illuminationDto.setLimit(limit);
        illuminationDto.setPage(page);
        illuminationDto.setHomeId(homeId);
        ResponseObject<List<IlluminationDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeIlluminationService.getList(illuminationDto));
        responseObject.setCount(homeIlluminationService.selectCount(homeId));
        return responseObject;
    }

    /**
     * 查询指定驴舍的光照的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listIlluminationHistoryByHomeId/{homeId}", method = RequestMethod.GET)
    private ResponseObject<List<IlluminationDto>> listIlluminationHistoryByHomeId(@PathVariable Long homeId){
        System.out.println("listIlluminationHistoryByDonkeyId");
        ResponseObject<List<IlluminationDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeIlluminationService.getByHomeId(homeId));
        responseObject.setCount(homeIlluminationService.selectCount(homeId));
        return responseObject;
    }

// -------------------------------------温度--------------------------

    /**
     * 查询所有温度的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listTemperatureHistory", method = RequestMethod.GET)
    private ResponseObject<List<TemperatureDto>> listTemperatureHistory(@RequestParam(value="page",defaultValue="1",required=true) int page
            , @RequestParam(value="limit",defaultValue="100",required=true) int limit
            , @RequestParam(value="homeId",defaultValue="1",required=true) long homeId){
        System.out.println("listTemperatureHistory");
        TemperatureDto temperatureDto = new TemperatureDto();
        temperatureDto.setLimit(limit);
        temperatureDto.setPage(page);
        temperatureDto.setHomeId(homeId);
        ResponseObject<List<TemperatureDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeTemperatureService.getList(temperatureDto));
        responseObject.setCount(homeTemperatureService.selectCount(homeId));
        return responseObject;
    }

    /**
     * 查询指定驴舍的温度的历史
     */

    @ResponseBody
    @RequestMapping(value = "/listTemperatureHistoryByDonkeyId/{homeId}", method = RequestMethod.GET)
    private ResponseObject<List<TemperatureDto>> listTemperatureHistoryByHomeId(@PathVariable Long homeId){
        System.out.println("listTemperatureHistoryByDonkeyId");
        ResponseObject<List<TemperatureDto>> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData(homeTemperatureService.getByHomeId(homeId));
        responseObject.setCount(homeTemperatureService.selectCount(homeId));
        return responseObject;
    }

}
