package lxw.addressbook.addressbook.service;

import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.common.StatusCode;
import lxw.addressbook.addressbook.util.RobotUtil;
import lxw.addressbook.addressbook.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class WechatService {

    public RestfulResponse getMessage(String message){
        String reply = RobotUtil.getReply(message);
        return RestfulResponse.getRestfulResponse(StatusCode.SELECT_SUCCESS,StringUtils.isNotEmpty(reply)?reply:null);
    }
}
