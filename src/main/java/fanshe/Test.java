package fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*********************************************************
 * 文件名称：Test
 * 系统名称：交易银行系统V1.0
 * 模块名称：fanshe
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/6/15 19:21
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Test {

    public static void main(String[] args) {
        Class<?> verify = Verify.class;

        System.out.println("TEST".substring(0, 1).toLowerCase() + "TEST".substring(1));
        try {
            Method method = verify.getMethod("verify", String.class, String.class, Map.class);
            String o = "ss";
            String t = "ff";
            Map<String, Object> r = new HashMap<>();
            r.put(o, "asdasd");
            try {
                method.invoke(verify.newInstance(), o, t, r);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
