package redis;

/*********************************************************
 * 文件名称：SpringRedis
 * 系统名称：交易银行系统V1.0
 * 模块名称：redis
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2019/12/27 10:34
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class SpringRedis {
    public static void main(String[] args) {

        ValueOperations<String,User> operations = redisTemplate.opsForValue();
    }
}
