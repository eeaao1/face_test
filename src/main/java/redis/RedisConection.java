package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*********************************************************
 * 文件名称：RedisConection
 * 系统名称：交易银行系统V1.0
 * 模块名称：Entity.entity007
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2019/12/23 16:15
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class RedisConection {
    public static void main(String[] args) {
        Jedis jedis = cli_single("192.168.33.148", 6379);
        jedis.set("key", "first Java connect!");
        String value = jedis.get("key");
        System.out.println(value);
    }

    /**
     * 单个连接
     *
     * @param host
     * @param port
     * @return
     */
    public static Jedis cli_single(String host, int port) {
        try {
            Jedis jedis = new Jedis(host, port);
            jedis.auth("cache@fsp");
            return jedis;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 连接池
     *
     * @param host
     * @param port
     * @return
     */
    public static Jedis cli_pool(String host, int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(10);
        // 最大连接空闲数
        config.setMaxIdle(2);
        JedisPool jedisPool = new JedisPool(config, host, port);
        try {
            return jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
