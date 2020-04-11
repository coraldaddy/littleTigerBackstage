package lxw.addressbook.addressbook.wechat.robot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static String chart(String message){
        StringBuffer sb=new StringBuffer();
        Random rand = new Random();
        ArrayList<String> KEYLIST=new ArrayList<String>();
        KEYLIST.add("8d64b5ff5a57435fa63fd0e111f821fc");//注册图灵机器人的账号，每创建一个机器人会给一个key,通过这个key来调用api
        KEYLIST.add("d085ed36e2604506968a3c18c5733116");//因为由每个key都有调用次数限制，这里存了多个key
        KEYLIST.add("4cdce663b3a44b5bb94cf62ca52de590");
        KEYLIST.add("88001fa9420d486a849bccbfcbcc7f9a");

        try{
            String APIKEY =KEYLIST.get(rand.nextInt(3));//随机选择用哪个key
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

        public static void main(String[] args) {
            myframe myframe=new myframe("机器人管家",100,100,800,500);
            myframe.setVisible(true);
            Test robot=new Test();
            Scanner sc = new Scanner(System.in);
            ArrayList<String> ability=new ArrayList<>();
            while(true){
                System.out.println("你说:");
                String message=sc.nextLine();
                if(message.equals("提醒")){

                }
                String result=robot.chart(message);
                System.out.println("机器人:"+result);
            }
        }

}
