package lxw.addressbook.addressbook.controller;

import lombok.extern.slf4j.Slf4j;
import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.common.StatusCode;
import lxw.addressbook.addressbook.domain.User;
import lxw.addressbook.addressbook.model.request.GetOpenIdRequest;
import lxw.addressbook.addressbook.model.request.SelectUserByOPenIdRequest;
import lxw.addressbook.addressbook.service.OrganService;
import lxw.addressbook.addressbook.service.SieveService;
import lxw.addressbook.addressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    //换取openId
    @PostMapping(value = "getOpenIdByCode")
    public RestfulResponse getOpenIdByCode(@RequestBody GetOpenIdRequest getOpenIdRequest){
        String openId = userService.getOpenIdByCode(getOpenIdRequest);
        if(openId == null ||"null".equals(openId)){
            return  RestfulResponse.getRestfulResponse(StatusCode.SERVER_EXCEPTION);
        }
        return RestfulResponse.getRestfulResponse(StatusCode.ACQUIRE_SUCCESS,openId);
    }
    @PostMapping(value = "checkRegister")
    public RestfulResponse checkRegister(@RequestBody SelectUserByOPenIdRequest selectUserByOPenIdRequest){
        List<User> user = userService.getUserByOpenId(selectUserByOPenIdRequest);
        if(user!=null &&user.size()==1){
            return RestfulResponse.getRestfulResponse(StatusCode.USER_IS_REGISTERED);
        }else{
            return RestfulResponse.getRestfulResponse(StatusCode.USER_NOT_REGISTERED);
        }
    }
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
