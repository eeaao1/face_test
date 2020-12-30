import fanshe.Fa;

import java.io.UnsupportedEncodingException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static void main(String[] args) throws UnsupportedEncodingException {
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
//        Person p = new Person();
//        Person pp = new Person();
//        p.setName("22");
//        p.setAge(1);
//        pp.setName("33");
//        pp.setAge(22);
//        Map<String, Person> ppp = new HashMap();
//        ppp.put("1", p);
//        ppp.put("2", pp);
//        Collection<Person> values = ppp.values();
//        for (Person v : values) {
//            System.out.println(v);
//        }
//        List<String> s = new ArrayList<>();
//        List<String> s1 = new ArrayList<>();
//        s.add("1");
//        s1.add("1");
//        s.add("2");
//        s.add("3");
//        s.add("4");
//        s.add("5");
//        System.out.println(s.removeAll(s1));
//        System.out.println(s1);
//        System.out.println(s);
//        try {
//            String s = "-999999999999";
//            BigDecimal urp = new BigDecimal(s);
//            if (BigDecimal.ZERO.compareTo(urp) > -1 || s.contains(".")) {
//                System.out.println("error");
//            }
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//        BigDecimal a = new BigDecimal("9994");
//        BigDecimal b = new BigDecimal("10000");
//        String s = "123456789";
//        System.out.println(s.substring(0, s.length() - 4));
//        String memberAcctNo = "111~";
//        String fieldRegex = "^[^%_<>]+$";
//        String fieldRegex2 = "^[^%_<>]+$!@#&*(){}|\"\":;.,?`~";
//        String fieldRegex3 = "^[^%_<>$+!@#&*()^\\[{}\\]|\"\'\\\\/:;.,?`~]+$";
//        Pattern pattern = Pattern.compile(fieldRegex3);
//        Matcher matcher = pattern.matcher(memberAcctNo);
//        if (!matcher.matches()) {
//            System.out.println(memberAcctNo + "格式不正确");
//        }
//        List<BigDecimal> numList = Arrays.asList(BigDecimal.ONE, BigDecimal.TEN,
//                new BigDecimal("2"), new BigDecimal("6"));
//        System.out.println(numList.stream().reduce((a, b) -> a.add(b)).get());
//        GsonJsonParser gson = new GsonJsonParser();
//        Date date = parsePlainDate("20190228");
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        if (c.get(Calendar.DAY_OF_MONTH) == c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
//            c.add(Calendar.YEAR, 1);
//            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
//        } else {
//            c.add(Calendar.YEAR, 1);
//        }
//        System.out.println(s(c.getTime()));
//        Date a = parsePlainDate("20190228");
//        Date b = parsePlainDate("20190228");
//        Period p = Period.between(a, b);
//        System.out.printf("目标日期距离今天的时间差：%d 年 %d 个月 %d 天\n", p.getYears(), p.getMonths(), p.getDays());
        List<String> s = new ArrayList<>();
        s.add("0");
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        List<String> strings = s.subList(0, 2);
        for (String v : strings) {
            System.out.println(v);
        }
    }

    public static void s(Fa f) {
        System.out.println(f.getClass());
    }

    private static String setFieldVal(String val, int length) {
        StringBuilder gbkString = null;
        try {
            gbkString = new StringBuilder(new String(val.getBytes("gbk")));
        } catch (UnsupportedEncodingException e) {
            System.out.println("cascas");
        }
        if (length < gbkString.length()) {
            System.out.println("字段长度超过限定");
        }
        for (int i = gbkString.toString().length(); i < length; i++) {
            gbkString.append("-");
        }
        return gbkString.toString();
    }

    public static Date parsePlainDate(String source) {
        SimpleDateFormat plainDateFormat = new SimpleDateFormat("yyyyMMdd");
        return plainDateFormat.parse(source, new ParsePosition(0));
    }

    public static String s(Date date) {
        SimpleDateFormat plainDateFormat = new SimpleDateFormat("yyyyMMdd");
        return plainDateFormat.format(date);
    }

}
