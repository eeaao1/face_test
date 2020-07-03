package fanshe;

import java.util.Map;

/*********************************************************
 * 文件名称：Verify
 * 系统名称：交易银行系统V1.0
 * 模块名称：fanshe
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/6/15 19:20
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Verify {

    public void verify(String o, String t, Map<String, Object> r) {
        System.out.println("verify......... o: " + o + ",t: " + t + ",r: " + r.get(o));
    }
}
