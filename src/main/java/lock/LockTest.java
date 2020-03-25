package lock;

/*********************************************************
 * 文件名称：LockTest
 * 系统名称：交易银行系统V1.0
 * 模块名称：lock
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/3/23 11:27
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class LockTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(threadTest);
            thread.start();
        }
    }
}
