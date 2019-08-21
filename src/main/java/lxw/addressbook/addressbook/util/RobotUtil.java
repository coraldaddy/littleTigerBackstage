package lxw.addressbook.addressbook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;

@Component
public class RobotUtil {

    @Autowired
    private RedisUtils redisUtils;

    public String getKey(){
//        String key = "8d64b5ff5a57435fa63fd0e111f821fc,d085ed36e2604506968a3c18c5733116,4cdce663b3a44b5bb94cf62ca52de590";
        String value = redisUtils.get("robotKey");
        String[] keys = value.split(",");
        Random rand = new Random();
        return keys[rand.nextInt(keys.length)];
    }

    public static String getReply(String message){
        RobotUtil robotUtil = new RobotUtil();
        String key = robotUtil.getKey();
        StringBuffer sb=new StringBuffer();
        try{
            String APIKEY = key;//随机选择用哪个key
            String INFO = URLEncoder.encode(message, "utf-8");//转换格式
            String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;//拼接请求url
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();//连接
            // 取得输入流，并使用Reader读取
            BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
            sb.setLength(0);//每次把Stingbuffer清空
            String line = "";
            while ((line = reader.readLine()) != null) {//读取结果
                sb.append(line);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
        }
        catch ( Exception e){
            e.printStackTrace();
        }
        String split[]=sb.toString().split(":");
        String answer=split[split.length-1];
        answer=answer.substring(1,answer.length()-2);//获取到回应
        return  answer;
    }
}
