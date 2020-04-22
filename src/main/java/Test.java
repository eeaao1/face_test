import pojo.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*********************************************************
 * 文件名称：Test
 * 系统名称：交易银行系统V1.0
 * 模块名称：PACKAGE_NAME
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/1/6 10:34
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Test {
    public static void main(String[] args) {
//        Person p = new Person();
//        Person p1 = null;
//        System.out.println("".hashCode());
//        BigDecimal amt = new BigDecimal("0.01");
//        DecimalFormat df = new DecimalFormat("###,##0.00");
//        String format = df.format(amt);
//        System.out.println(format);
//
//        NumberFormat nf = NumberFormat.getPercentInstance();
//        nf.setMinimumFractionDigits(2);
//        System.out.println(nf.format(amt));
//        System.out.println("yyyyMMddHHmmss".substring(0, 8));
//        System.out.println("yyyyMMddHHmmss".substring(8));
        Person p = new Person();
        Person pp = new Person();
        p.setName("22");
        p.setAge(1);
        pp.setName("33");
        pp.setAge(22);
        Map<String, Person> ppp = new HashMap();
        ppp.put("1", p);
        ppp.put("2", pp);
        Collection<Person> values = ppp.values();
        for (Person v : values) {
            System.out.println(v);
        }
//        try {
//            String s = "-999999999999";
//            BigDecimal urp = new BigDecimal(s);
//            if (BigDecimal.ZERO.compareTo(urp) > -1 || s.contains(".")) {
//                System.out.println("error");
//            }
//        } catch (Exception e) {
//            System.out.println("error");
//        }
    }
}
