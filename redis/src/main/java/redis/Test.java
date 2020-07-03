package redis;

import redis.clients.jedis.Jedis;

/*********************************************************
 * 文件名称：Test
 * 系统名称：交易银行系统V1.0
 * 模块名称：redis
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/7/3 17:59
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Test {

    public static void main(String[] args) {
        try {
            Jedis jedis = new Jedis("10.20.47.206", 6379);
            jedis.auth("cache@fsp");
            System.out.println("args[0]:" + args[0]);
            String[] split = args[0].split(",");
            //1-asset
            jedis.set("asset", split[0]);
            //2-bank
            jedis.set("bank", split[1]);
            //3-verify
            jedis.set("verify", split[2]);
            String asset = jedis.get("asset");
            String bank = jedis.get("bank");
            String verify = jedis.get("verify");
            System.out.println("asset:" + asset);
            System.out.println("bank:" + bank);
            System.out.println("verify:" + verify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //redis-cli -h 10.20.47.206 -p 6379 -a cache@fsp
    //set kongli lock
    //del kongli
}
