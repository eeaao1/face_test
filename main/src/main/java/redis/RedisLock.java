package redis;

import redis.clients.jedis.Jedis;

import java.math.BigDecimal;

/*********************************************************
 * 文件名称：RedisLock
 * 系统名称：交易银行系统V1.0
 * 模块名称：redis
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/3/24 13:41
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class RedisLock {

    private final static String LOCK = "src/main/java/lock";
    private Long waitingTime = 30000L;
    private Long outOffTime = 30000L;


    public static void main(String[] args) {
        Jedis jedis = RedisConection.cli_single("192.168.33.148", 6379);
//        jedis.del("kongli");
//        jedis.del("nojnl");
        jedis.set("kongli", LOCK);
        System.out.println("kongli:" + jedis.get("kongli"));
        System.out.println("nojnl:" + jedis.get("nojnl"));
    }

    public RedisLock() {
    }

    public RedisLock(Long waitingTime, Long outOffTime) {
        this.waitingTime = waitingTime;
        this.outOffTime = outOffTime;
    }

    public void tryLock(String key) {
        Jedis jedis = RedisConection.cli_single("192.168.33.148", 6379);
        jedis.set(key, LOCK);
    }

    public Boolean isLocked(String key) {
        return true;
    }

}
