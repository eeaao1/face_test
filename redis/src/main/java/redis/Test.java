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
            Jedis jedis = new Jedis("10.20.25.197", 6379);
            jedis.auth("cache@fsp");
            System.out.println("args[0]:" + args[0]);
            String[] split = args[0].split(",");
            //1 - asset
            jedis.set("asset", split[0]);
            //1-assetRollback
            jedis.set("assetRollback", split[1]);
            //2-bank
            jedis.set("bank", split[2]);
            //3-verify
            jedis.set("verify", split[3]);
            if (split.length == 8) {
                //1-payOutAsset
                jedis.set("payOutAsset", split[4]);
                //1-payOutAssetRollback
                jedis.set("payOutAssetRollback", split[5]);
                //2-payOutBank
                jedis.set("payOutBank", split[6]);
                //3-payOutVerify
                jedis.set("payOutVerify", split[7]);
            }
            String asset = jedis.get("asset");
            String assetRollback = jedis.get("assetRollback");
            String bank = jedis.get("bank");
            String verify = jedis.get("verify");
            String payOutAsset = jedis.get("payOutAsset");
            String payOutAssetRollback = jedis.get("payOutAssetRollback");
            String payOutBank = jedis.get("payOutBank");
            String payOutVerify = jedis.get("payOutVerify");
            System.out.println("asset:" + asset);
            System.out.println("assetRollback:" + assetRollback);
            System.out.println("bank:" + bank);
            System.out.println("verify:" + verify);
            System.out.println("payOutAsset:" + payOutAsset);
            System.out.println("payOutAssetRollback:" + payOutAssetRollback);
            System.out.println("payOutBank:" + payOutBank);
            System.out.println("payOutVerify:" + payOutVerify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //redis-cli -h 10.20.47.206 -p 6379 -a cache@fsp
    //set kongli lock
    //del kongli
}
