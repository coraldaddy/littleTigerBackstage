package lxw.addressbook.addressbook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtils {

    @Autowired
    private JedisPool jedisPool;

    public String get(String s){
        Jedis jedis = jedisPool.getResource();
        String a = jedis.get(s);
        jedis.close();
        return a;
    }
    public String set(String name,String value){
        Jedis jedis = jedisPool.getResource();
        String a = jedis.set(name,value);
        jedis.close();
        return a;
    }

}
