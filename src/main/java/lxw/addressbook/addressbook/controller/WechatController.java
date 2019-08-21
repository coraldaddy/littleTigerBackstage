package lxw.addressbook.addressbook.controller;

import lombok.extern.slf4j.Slf4j;
import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.model.request.MessageRequest;
import lxw.addressbook.addressbook.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述: 微信相关的Controller
 * @auther: lxw
 * @date: 2019/8/21 19:48
 */
@RestController
@Slf4j
@RequestMapping("wechat")
public class WechatController {

    @Autowired private WechatService wechatService;

    /**
     * 功能描述: 基于图灵机器人实现聊天
     * @auther: lxw
     * @date: 2019/8/21 19:17
     */
    @PostMapping("getMessage")
    public RestfulResponse getMessage(@RequestBody MessageRequest messageRequest){
       return wechatService.getMessage(messageRequest.getMessage());
    }
}
