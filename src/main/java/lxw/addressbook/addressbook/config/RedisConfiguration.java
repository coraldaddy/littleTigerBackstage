package lxw.addressbook.addressbook.config;

import lombok.extern.slf4j.Slf4j;
import lxw.addressbook.addressbook.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

    //Redis服务器IP
    @Value("${lxw.redis.cache.addr}")
    private String addr;

    //Redis的端口号
    @Value("${lxw.redis.cache.port}")
    private int port;

    //Redis的密码
    @Value("${lxw.redis.cache.password}")
    private String password;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    @Value("${lxw.redis.cache.maxActive}")
    private int maxActive;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值8。
    @Value("${lxw.redis.cache.maxIdle}")
    private int maxIdle;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    @Value("${lxw.redis.cache.maxWait}")
    private int maxWait;

    @Value("${lxw.redis.cache.timeout}")
    private int timeout;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    @Value("${lxw.redis.cache.testOnBorrow}")
    private boolean testOnBorrow;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        JedisPool jedisPool = null;
        if(StringUtils.isEmpty(password)){
            jedisPool = new JedisPool(jedisPoolConfig,addr,port,timeout);
        }else{
            jedisPool = new JedisPool(jedisPoolConfig,addr,port,timeout,password);
        }
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + addr + ":" + port);
        return jedisPool;
    }
}
