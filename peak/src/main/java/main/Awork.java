package main;

/*********************************************************
 * 文件名称：Awork
 * 系统名称：交易银行系统V1.0
 * 模块名称：main
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/21 19:47
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Awork extends AbstractWork {

    @Override
    void before() {
        System.out.println(this.getClass().toString() + ":before");
    }

    @Override
    void after() {
        System.out.println(this.getClass().toString() + ":after");
    }
}
