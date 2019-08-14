package lxw.addressbook.addressbook.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lxw.addressbook.addressbook.domain.Sieve;
import lxw.addressbook.addressbook.domain.User;
import lxw.addressbook.addressbook.mapper.SieveMapper;
import lxw.addressbook.addressbook.mapper.UserMapper;
import lxw.addressbook.addressbook.model.request.GetOpenIdRequest;
import lxw.addressbook.addressbook.model.request.SelectUserByOPenIdRequest;
import lxw.addressbook.addressbook.util.HttpUtil;
import lxw.addressbook.addressbook.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private String appId = "wx1a17619450b6dd23";

    private String AppSecret = "015dc880c55bd73ed2b0ad078737c502";

    private String grantType = "authorization_code";

    @Autowired private UserMapper userMapper;

    @Autowired private SieveMapper sieveMapper;

    @Autowired private RedisUtils redisUtils;

    public int addUser(User user) {
        int i =userMapper.insert(user);
        redisUtils.set(user.getOpenId(),JSONObject.toJSONString(user));
        Sieve sieve = new Sieve();
        sieve.setUserId(user.getId());
        sieve.setJetton("5000");
        sieveMapper.insertSelective(sieve);

       return i;
    }

    public String getOpenIdByCode(GetOpenIdRequest getOpenIdRequest) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "appid="+appId+"&secret="+AppSecret+"&js_code="+getOpenIdRequest.getCode()+"&grant_type="+grantType;
        String responce = HttpUtil.get(url,params);
        JSONObject resultJson = JSON.parseObject(responce);
        //获取openId
        String openId = String.valueOf(resultJson.get("openid"));
        String sessionKey = String.valueOf(resultJson.get("session_key"));
        return openId;
    }

    public User getUserByOpenId(SelectUserByOPenIdRequest selectUserByOPenIdRequest) {
        String userString = redisUtils.get(selectUserByOPenIdRequest.getOpenId());
        if(userString!=null&&userString.length()>0){
            return  JSONObject.parseObject(userString, User.class);
        }else{
            List<User> users = userMapper.SelectUserByOPenIdRequest(selectUserByOPenIdRequest.getOpenId());
            return users!=null&&users.size()==1?users.get(0):null;
        }
    }
}
