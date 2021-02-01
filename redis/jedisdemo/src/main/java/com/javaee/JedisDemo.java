package com.javaee;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class JedisDemo {
    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("192.168.0.37", 6379);
        jedis.set("name", "李四");
        String result = jedis.get("name");
        System.out.println(result);
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool("192.168.0.37", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("name", "吴彦祖");
        String result = jedis.get("name");
        System.out.println(result);
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testSentinel() {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.0.37:26379");
        sentinels.add("192.168.0.37:26380");
        sentinels.add("192.168.0.37:26381");

        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = pool.getResource();
        jedis.set("city", "北京市海淀区西二旗");
        String result = jedis.get("city");
        System.out.println(result);
        jedis.close();
        pool.close();
    }
}
