package fanshe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*********************************************************
 * 文件名称：EnumF
 * 系统名称：交易银行系统V1.0
 * 模块名称：fanshe
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/1/2 11:20
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class EnumF {

    public void test() throws Exception {
        Class<EnumT> clz = EnumT.class;
        Object[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod("getCode");
        Method getMessage = clz.getMethod("getDesc");
        List<Map<String, String>> list = new ArrayList<>();
        //        Map<String, String> map = null;
        StringBuilder sb = new StringBuilder();
        for (Object obj : objects) {
            //            map = new HashMap<>();
            //            map.put(KEY_CODE, (String) getCode.invoke(obj));
            //            map.put(KEY_DESC, (String) getMessage.invoke(obj));
            //            list.add(map);
            sb.append((String) getCode.invoke(obj) + "=" + (String) getMessage.invoke(obj) + "\n");
        }
    }
}
