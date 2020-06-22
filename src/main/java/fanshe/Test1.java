package fanshe;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 * 文件名称：Test1
 * 系统名称：交易银行系统V1.0
 * 模块名称：fanshe
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/6/20 11:39
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Test1 {
    public static void main(String[] args) {
        Son son = new Son();
        son.setFa("fa");
        son.setSon("son");
        ss(son);
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        System.out.println(s.subList(0, 3));
    }

    public static void ss(Fa fa) {
        Son s = (Son) fa;
        System.out.println(s);
    }
}
