package lxw.addressbook.addressbook.controller;

import lombok.extern.slf4j.Slf4j;
import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.common.StatusCode;
import lxw.addressbook.addressbook.domain.User;
import lxw.addressbook.addressbook.model.request.GetOpenIdRequest;
import lxw.addressbook.addressbook.model.request.SelectUserByOPenIdRequest;
import lxw.addressbook.addressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 功能描述:用户相关的Controller
 * @auther: lxw
 * @date: 2019/8/14 19:27
 */
@Slf4j
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping(value = "showUser")
    public String showUser(){
        System.out.println("123123123123");
        return null;
    }

    /**
     * 功能描述: 通过code换取openId
     * @auther: lxw
     * @date: 2019/8/14 09:26
     */
    @PostMapping(value = "getOpenIdByCode")
    public RestfulResponse getOpenIdByCode(@RequestBody GetOpenIdRequest getOpenIdRequest){
        String openId = userService.getOpenIdByCode(getOpenIdRequest);
        if(openId == null ||"null".equals(openId)){
            return  RestfulResponse.getRestfulResponse(StatusCode.SERVER_EXCEPTION);
        }
        return RestfulResponse.getRestfulResponse(StatusCode.ACQUIRE_SUCCESS,openId);
    }
    /**
     * 功能描述:通过openId检查是否注册为用户
     * @auther: lxw
     * @date: 2019/8/14 09:27
     */
    @PostMapping(value = "checkRegister")
    public RestfulResponse checkRegister(@RequestBody SelectUserByOPenIdRequest selectUserByOPenIdRequest){
        User user = userService.getUserByOpenId(selectUserByOPenIdRequest);
        if(user!=null){
            return RestfulResponse.getRestfulResponse(StatusCode.USER_IS_REGISTERED);
        }else{
            return RestfulResponse.getRestfulResponse(StatusCode.USER_NOT_REGISTERED);
        }
    }

    /**
     * 功能描述: 添加用户信息
     * @auther: lxw
     * @date: 2019/8/21 19:46
     */
    @PostMapping(value = "addUser")
    public RestfulResponse addUser(@RequestBody User user){
        int i =userService.addUser(user);
        if(i==1){
            return RestfulResponse.getRestfulResponse(StatusCode.ADD_SUCCESS);
        }else{
            return RestfulResponse.getRestfulResponse(StatusCode.ADD_FALL);
        }
    }
}
