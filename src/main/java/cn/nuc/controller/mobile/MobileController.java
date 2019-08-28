package cn.nuc.controller.mobile;

import cn.nuc.dto.MobileInfo;
import cn.nuc.dto.ResponseObject;
import cn.nuc.dto.UserDto;
import cn.nuc.service.DonkeyService;
import cn.nuc.service.HomeService;
import cn.nuc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mobile")
public class MobileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private HomeService homeService;

    @Autowired
    private DonkeyService donkeyService;

    /**
     * 添加用户
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseObject addUser(MobileInfo dto){
        System.out.println("testUser");
        ResponseObject<String> responseObject=new ResponseObject<>();
        System.out.println(dto.getMsg());
        responseObject.setMsg("收到，请继续完成任务！");
        responseObject.setCount(1);
        responseObject.setCode(0);
        return responseObject;
    }

}
