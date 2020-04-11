package lxw.addressbook.addressbook.wechat;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: 实现微信自动回复等功能
 * @auther: lxw
 * @date: 2019/8/21 19:08
 */
@Slf4j
public class HelloBot extends WeChatBot {

    public HelloBot(Config config) {
        super(config);
    }

    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    @Bind(accountType = AccountType.TYPE_GROUP)
    public void groupMessage(WeChatMessage message) {
        if(StringUtils.isNotEmpty(message.getName())){
            log.info("接收到群 [{}] 的消息: {}", message.getName(), message.getText());
            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    @Bind(accountType = AccountType.TYPE_FRIEND)
    public void friendMessage(WeChatMessage message) {
        if(StringUtils.isNotEmpty(message.getName())){
            log.info("接收到好友 [{}] 的消息: {}", message.getName(), message.getText());
            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    /**
     * 功能描述: 目前微信网页版不支持登录，所以该方法已经实现不了了
     * @auther: lxw
     * @date: 2019/8/21 19:08
     */
    public static void main(String[] args) {
        new HelloBot(Config.me().autoLogin(true).showTerminal(true)).start();
    }

}