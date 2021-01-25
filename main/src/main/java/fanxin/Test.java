package fanxin;

import pojo.Father;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：fanxin
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2020/8/11 23:37
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class Test {

    public static void main(String[] args) {
//        Gener<? extends Father> objectGener = new Gener<>();
//        List<?> l = new ArrayList<>();
//        l.add("1");
//        Father father = new Father();
//        father.setWife("1234");
//        objectGener.setS(father);
//        Object ss = ss(objectGener);
//        System.out.println(ss);
    }

    public static <T> T ss(Gener<T> g) {

        return g.getS();
    }
}
