package fanxin;


import pojo.Person;

/*********************************************************
 * 文件名称：Gener
 * 系统名称：交易银行系统V2.0
 * 模块名称：fanxin
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2020/8/11 23:36
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class Gener<T>  implements BaseGen<Person> {

    private T s;

    public T getS() {
        return s;
    }

    public void setS(T s) {
        this.s = s;
    }
}
