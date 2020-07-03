package messageFormat;

import java.text.MessageFormat;

/*********************************************************
 * 文件名称：MsgFormat
 * 系统名称：交易银行系统V1.0
 * 模块名称：messageFormat
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/22 19:37
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class MsgFormat {

    public static void main(String[] args) {
        System.out.println(format("1{}2{}3{}", "1", null, null));
    }

    public static String format(String description, String... args) {
        String[] dsArr = (description + ".").split("\\{}");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dsArr.length; i++) {
            sb.append(dsArr[i]);
            if (dsArr.length - 1 > i) {
                sb.append("{");
                sb.append(i);
                sb.append("}");
            }
        }
        return MessageFormat.format(sb.toString(), args);
    }
}
