package bit;

import org.springframework.util.StringUtils;

/*********************************************************
 * 文件名称：BitOperation
 * 系统名称：交易银行系统V1.0
 * 模块名称：bit
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/5/21 19:57
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class BitOperation {


    public static void main(String[] args) {
//        int i = 1;
//        System.out.println("before:[" + i + "]二进制:" + Integer.toBinaryString(i));
//        i = i << 2;
//        System.out.println("after:[" + i + "] 二进制:" + Integer.toBinaryString(i));

        Query ss1 = ss("F", "C");
        Query ss2 = ss("F", "D");
        Query ss3 = ss("J", "C");
        Query ss4 = ss("J", "D");
        if (StringUtils.isEmpty(ss1.getoA()) || StringUtils.isEmpty(ss1.getoC())) {
            System.out.println("error1");
        }
        if (StringUtils.isEmpty(ss2.getBenA()) || StringUtils.isEmpty(ss2.getBenC())) {
            System.out.println("error2");
        }
        if (StringUtils.isEmpty(ss3.getBenA()) || StringUtils.isEmpty(ss3.getBenC())) {
            System.out.println("error3");
        }
        if (StringUtils.isEmpty(ss4.getoA()) || StringUtils.isEmpty(ss4.getoC())) {
            System.out.println("error4");
        }
    }


    public static Query ss(String type, String crdr) {
        Query query = new Query();
//        if ("F".equals(type)) {
//            //委贷放款 收入 时 查询借款人
//            if ("C".equals(crdr)) {
//                query.setoA("a");
//                query.setoC("c");
//            } else {
//                //委贷放款 支出 时 查询委托人
//                query.setBenA("a");
//                query.setBenC("c");
//            }
//        } else if ("J".equals(type)) {
//            //委贷还款 收入 时 查询委托人
//            if ("C".equals(crdr)) {
//                query.setBenA("a");
//                query.setBenC("c");
//            } else {
//                //委贷还款 支出 时 查借款人
//                query.setoA("a");
//                query.setoC("c");
//            }
//        }
        int i = 1;
        if ("J".equals(type)) {
            i = i << 1;
        }
        if ("D".equals(type)) {
            i = i << 1;
        }
        if (i == 1) {
            query.setoA("a");
            query.setoC("c");
        } else {
            query.setBenA("a");
            query.setBenC("c");
        }

        return query;
    }

}
