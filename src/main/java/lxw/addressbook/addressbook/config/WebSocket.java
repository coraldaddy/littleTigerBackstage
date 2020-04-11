package lxw.addressbook.addressbook.config;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


import com.alibaba.fastjson.JSONObject;
//import net.sf.json.JSONObject;

/**
 * @ServerEndpoint 注解：websocket是ws时的地址，后面是用户ID
 */
@ServerEndpoint("/websocket/{userInfo}")
public class WebSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<Integer,Session> mapUS = new ConcurrentHashMap<Integer,Session>();//根据用户找session
    private static ConcurrentHashMap<Session,Integer> mapSU = new ConcurrentHashMap<Session,Integer>();//根据session找用户

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("userInfo") Integer userInfo){
        this.session = session;
        mapUS.put(userInfo,session);//添加唯一标识的用户ID为key，session为值
        mapSU.put(session,userInfo);//添加session为key，唯一标识的用户ID为值
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session){
        Integer userId = mapSU.get(session);
        mapUS.remove(userId);
        mapSU.remove(session);
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        JSONObject jsonObject=JSONObject.parseObject(message);//.fromObject(message);
        Integer id = jsonObject.getInteger("id");//.getInt("id");//获取ID信息，群发就不用了
        String content = jsonObject.getString("content");//获取发送信息，群发还是需要的
        Session session_to=mapUS.get(id);//这是发送个人信息
        //群发消息
        /*for(websocket item: webSocketSet){
            try {
                item.sendMessage(content);//这里是调用了下面的sendMessage方法
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/
        if(id==null||content==null||content==""){return ;}
        session_to.getAsyncRemote().sendText(content);//群发就不用了，个人的session发送过去
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param
     * @throws IOException
     */
    /*public void sendMessage(String message) throws IOException{
        this.session.getAsyncRemote().sendText(message);//发送给全局变量session中用户信息
    }*/

    public static synchronized int getOnlineCount() {
        return onlineCount;//返回在线人数
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;//在线人数+1
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;//在线人数-1
    }
}

