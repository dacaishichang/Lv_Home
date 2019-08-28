package cn.nuc.controller.system;

import cn.nuc.dto.ResponseObject;
import cn.nuc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.nuc.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户相关
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 添加驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseObject addDonkey(@RequestBody UserDto dto){
		System.out.println("loginUser");
		System.out.println(dto.getUseraccount()+":"+dto.getPassword());
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(userService.validate(dto)){
			System.out.println("登录成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}
}
