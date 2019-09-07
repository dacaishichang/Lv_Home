package cn.nuc.controller.api;

import java.util.List;

import cn.nuc.dto.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.nuc.dto.DonkeyDto;
import cn.nuc.dto.HomeDto;
import cn.nuc.dto.UserDto;
import cn.nuc.service.DonkeyService;
import cn.nuc.service.HomeService;
import cn.nuc.service.UserService;

/**
 * 数据接口和三个表的增删改查
 */

@Controller
@RequestMapping("/api")
public class ApiController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private DonkeyService donkeyService;

	//用户表--------------------------------------------------------------------------

	/**
	 * 查询所有用户
	 */
//@RequestParam(value="page",defaultValue="1",required=true) int page,@RequestParam(value="limit",defaultValue="10",required=true) int limit
	@ResponseBody
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	private ResponseObject listUsers(@RequestParam(value="page",defaultValue="1",required=true) int page
			,@RequestParam(value="limit",defaultValue="10",required=true) int limit) {
		System.out.println("listUsers");
		UserDto dto=new UserDto();
		dto.setLimit(limit);
		dto.setPage(page);
		ResponseObject<List<UserDto>> responseObject=new ResponseObject<>();
		responseObject.setCode(0);
		responseObject.setMsg("");
		responseObject.setData(userService.getList(dto));
		responseObject.setCount(userService.selectCount());
		return responseObject;
	}
	
	/**
	 * 添加用户
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseObject addUser(@RequestBody UserDto dto){
		System.out.println("addUser");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(userService.add(dto)){
			System.out.println("添加成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 单次删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	public ResponseObject deleteUser(@PathVariable Long userId){
		System.out.println("deleteUser");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(userService.remove(userId)){
			System.out.println("删除成功！");
			responseObject.setMsg("delete_success");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 全部删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAllUser", method = RequestMethod.GET)
//	传入：http://localhost:8080/api/deleteAllUser?data=10,11,12,13,14
	public ResponseObject<String> deleteAllUser(@RequestParam(value="data") Long[] data){
		System.out.println("deleteAllUser:"+data.length);
		int count=0;
		ResponseObject<String> responseObject=new ResponseObject<>();
		for(Long item:data){
			if(userService.remove(item)){
				count++;
				System.out.println("删除:"+item);
			};
		}
		if(data.length==count){
			System.out.println("删除所有成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(count);
			responseObject.setCode(0);
		}
		return responseObject;
	}

	/**
	 * 修改用户信息
	 */

	@ResponseBody
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ResponseObject editUser(@RequestBody UserDto dto){
		System.out.println("editUser");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(userService.modify(dto)){
			System.out.println("修改成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	//驴舍表--------------------------------------------------------------------------

	/**
	 * 查询所有驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/listHomes", method = RequestMethod.GET)
	private ResponseObject<List<HomeDto>> listHomes(@RequestParam(value="page",defaultValue="1",required=true) int page
			,@RequestParam(value="limit",defaultValue="10",required=true) int limit) {
		System.out.println("listHomes");
		HomeDto dto = new HomeDto();
		dto.setPage(page);
		dto.setLimit(limit);
		ResponseObject<List<HomeDto>> responseObject=new ResponseObject<>();
		responseObject.setCode(0);
		responseObject.setMsg("");
		responseObject.setData(homeService.getList(dto));
		responseObject.setCount(homeService.selectCount());
		return responseObject;
	}

	/**
	 * 添加驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/addHome", method = RequestMethod.POST)
	public ResponseObject addHome(@RequestBody HomeDto dto){
		System.out.println("addHome");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(homeService.add(dto)){
			System.out.println("添加成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 修改驴舍信息
	 */

	@ResponseBody
	@RequestMapping(value = "/editHome", method = RequestMethod.POST)
	public ResponseObject editHome(@RequestBody HomeDto dto){
		System.out.println("editHome");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(homeService.modify(dto)){
			System.out.println("修改成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 全部删除驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAllHome", method = RequestMethod.GET)
//	传入：http://localhost:8080/api/deleteAllUser?data=10,11,12,13,14
	public ResponseObject<String> deleteAllHome(@RequestParam(value="data") Long[] data){
		System.out.println("deleteAllHome:"+data.length);
		int count=0;
		ResponseObject<String> responseObject=new ResponseObject<>();
		for(Long item:data){
			if(homeService.remove(item)){
				count++;
				System.out.println("删除:"+item);
			};
		}
		if(data.length==count){
			System.out.println("删除所有成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(count);
			responseObject.setCode(0);
		}
		return responseObject;
	}

	/**
	 * 单次删除驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteHome/{homeId}", method = RequestMethod.GET)
	public ResponseObject deleteHome(@PathVariable Long homeId){
		System.out.println("deleteHome");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(homeService.remove(homeId)){
			System.out.println("删除成功！");
			responseObject.setMsg("delete_success");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	//驴表--------------------------------------------------------------------------

	/**
	 * 查询所有驴
	 */
	@ResponseBody
	@RequestMapping(value = "/listDonkeys", method = RequestMethod.GET)
	private ResponseObject<List<DonkeyDto>> listDonkeys(@RequestParam(value="page",defaultValue="1",required=true) int page
			,@RequestParam(value="limit",defaultValue="10",required=true) int limit) {
		System.out.println("listDonkeys");
		DonkeyDto dto = new DonkeyDto();
		dto.setLimit(limit);
		dto.setPage(page);
		ResponseObject<List<DonkeyDto>> responseObject=new ResponseObject<>();
		responseObject.setCode(0);
		responseObject.setMsg("");
		responseObject.setData(donkeyService.getList(dto));
		responseObject.setCount(donkeyService.selectCount());
		responseObject.setSize(responseObject.getData().size());
		return responseObject;
	}

	/**
	 * 添加驴舍
	 */
	@ResponseBody
	@RequestMapping(value = "/addDonkey", method = RequestMethod.POST)
	public ResponseObject addDonkey(@RequestBody DonkeyDto dto){
		System.out.println("addDonkey");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(donkeyService.add(dto)){
			System.out.println("添加成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 修改驴信息
	 */

	@ResponseBody
	@RequestMapping(value = "/editDonkey", method = RequestMethod.POST)
	public ResponseObject editDonkey(@RequestBody DonkeyDto dto){
		System.out.println("editDonkey");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(donkeyService.modify(dto)){
			System.out.println("修改成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}

	/**
	 * 全部删除驴
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAllDonkey", method = RequestMethod.GET)
//	传入：http://localhost:8080/api/deleteAllUser?data=10,11,12,13,14
	public ResponseObject<String> deleteAllDonkey(@RequestParam(value="data") Long[] data){
		System.out.println("deleteAllDonkey:"+data.length);
		int count=0;
		ResponseObject<String> responseObject=new ResponseObject<>();
		for(Long item:data){
			if(donkeyService.remove(item)){
				count++;
				System.out.println("删除:"+item);
			};
		}
		if(data.length==count){
			System.out.println("删除所有成功！");
			responseObject.setMsg("OK");
			responseObject.setCount(count);
			responseObject.setCode(0);
		}
		return responseObject;
	}

	/**
	 * 单次删除驴
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteDonkey/{donkeyId}", method = RequestMethod.GET)
	public ResponseObject deleteDonkey(@PathVariable Long donkeyId){
		System.out.println("deleteDonkey");
		ResponseObject<String> responseObject=new ResponseObject<>();
		if(donkeyService.remove(donkeyId)){
			System.out.println("删除成功！");
			responseObject.setMsg("delete_success");
			responseObject.setCount(1);
			responseObject.setCode(0);
		};
		return responseObject;
	}




}
