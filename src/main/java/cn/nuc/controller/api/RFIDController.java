package cn.nuc.controller.api;


import cn.nuc.dto.DonkeyDto;
import cn.nuc.dto.DonkeyHistoryDto;
import cn.nuc.dto.ResponseObject;
import cn.nuc.dto.UserDto;
import cn.nuc.entity.DonkeyHistory;
import cn.nuc.entity.RFIDPackage;
import cn.nuc.service.DonkeyHistoryService;
import cn.nuc.service.DonkeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//对于rfid的
@Controller
@RequestMapping("/rfid")
public class RFIDController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DonkeyService donkeyService;

    @Autowired
    private DonkeyHistoryService donkeyHistoryService;

    /**
     * 查询是否存在
     * 插入Donkey
     * 插入DonkeyHistory
     */
    //@RequestParam(value="page",defaultValue="1",required=true) int page,@RequestParam(value="limit",defaultValue="10",required=true) int limit
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private ResponseObject listUsers() {
        System.out.println("testrfid");
        ResponseObject<String> responseObject=new ResponseObject<>();
        responseObject.setCode(0);
        responseObject.setMsg("");
        responseObject.setData("烦死了");
        responseObject.setCount(1);
        return responseObject;
    }

    @ResponseBody
    @RequestMapping(value = "/sendList", method = RequestMethod.POST)
    private ResponseObject<String> sendList(@RequestBody RFIDPackage rfidPackage) {
        System.out.println("sendList");
        String RFIDInfo = rfidPackage.getCardId();
        System.out.println(RFIDInfo);
        ResponseObject<String> responseObject = new ResponseObject<String>();
        if(validateDonkeyByRFID(RFIDInfo.trim())){
            System.out.println("已经存在");
            addDonkeyHistory(RFIDInfo.trim());
            responseObject.setMsg("插入历史");
        }else {
            System.out.println("还不存在");
            addDonkeyByFRID(RFIDInfo.trim());
            responseObject.setMsg("插入实体");
        }
        return responseObject;
    }


    //验证RFID是否存在
    public boolean validateDonkeyByRFID(String RFIDInfo){
        DonkeyDto donkeyDto = new DonkeyDto();
        donkeyDto.setRFIDInfo(RFIDInfo);
        return donkeyService.validate(donkeyDto);
    }

    //添加到驴个体表中
    public boolean addDonkeyByFRID(String RFIDInfo){
        DonkeyDto donkeyDto = new DonkeyDto();
        donkeyDto.setHomeId(1L);
        donkeyDto.setGender("雄");
        donkeyDto.setSize(15l);
        donkeyDto.setRFIDInfo(RFIDInfo);
        return donkeyService.add(donkeyDto);
    }

    public boolean addDonkeyHistory(String RFIDInfo){
        DonkeyDto donkeyDto = new DonkeyDto();
        donkeyDto.setRFIDInfo(RFIDInfo);
        donkeyDto.setPage(1);
        donkeyDto.setLimit(100);
        List<DonkeyDto> donkeyList = donkeyService.getList(donkeyDto);

        DonkeyHistoryDto donkeyHistoryDto = new DonkeyHistoryDto();
        donkeyHistoryDto.setRFIDInfo(RFIDInfo);
        donkeyHistoryDto.setSize(donkeyList.get(0).getSize());
        donkeyHistoryDto.setDonkeyId(donkeyList.get(0).getDonkeyId());
        donkeyHistoryDto.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return donkeyHistoryService.add(donkeyHistoryDto);
    }
}
