//package cron;
//
//import com.google.common.base.Joiner;
//import com.google.common.base.Splitter;
//import org.springframework.util.CollectionUtils;
//
//import java.text.ParsePosition;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.stream.Collectors;
//
///*********************************************************
// * 文件名称：Test
// * 系统名称：交易银行系统V1.0
// * 模块名称：cron
// * 功能说明：${TODO}
// * 开发人员：kongli26489
// * 开发时间：2020/6/22 18:44
// * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
// *********************************************************/
//public class Test {
//
//
//    public static void main(String[] args) {
//
//
////        System.out.println(getGatherCron("5", "3", "10:00,11:30,12:00,12:30"));
//        System.out.println(Splitter.on(" ").splitToList("0 0 0 7/14 * ? *").get(3).contains("/"));
//
//    }
//
//
//    /**
//     * 计算下次归集时间
//     *
//     * @param periodType  归集周期 G00217 0-每天 1-隔天 2-每周 3-每月 4-月末 10-每年
//     * @param periodValue 归集周期属性 隔天：1,5   每周：1,3  每月： 11,23  每年：0918,1010
//     * @param gatherTimes 归集时点 10:00,11:30,……
//     * @return Object
//     */
//    public static String getGatherCron(String periodType, String periodValue, String gatherTimes) {
//        //归集周期 = 每年
////        if (G00217.USER_DEFINED.getCode().equals(periodType)) {
////            return G00217.USER_DEFINED.getCode() + "|" + periodValue + "|" + gatherTimes;
////        } else {
////            List<String> crons = new ArrayList<>();
////            //归集时点
////            List<String> times = Splitter.on(",").splitToList(gatherTimes);
////            //含30分钟的归集时点集合
////            List<String> times30 = times.stream().filter(time -> time.contains(":30")).collect(Collectors.toList());
////            //整点的归集时点集合
////            List<String> times60 = times.stream().filter(time -> time.contains(":00")).collect(Collectors.toList());
////            //含30分钟的归集时点集合 非空
////            if (!CollectionUtils.isEmpty(times30)) {
////                crons.add(getGatherCron(periodType, periodValue, times30, true));
////            }
////            //整点的归集时点集合 非空
////            if (!CollectionUtils.isEmpty(times60)) {
////                crons.add(getGatherCron(periodType, periodValue, times60, false));
////            }
//            return Joiner.on("|").join(crons);
//        }
//    }
//
//    /**
//     * 获取归集Cron表达式
//     *
//     * @param periodType  归集周期  G00217 0-每天 1-隔天 2-每周 3-每月 4-月末 10-每年
//     * @param periodValue 归集周期属性 隔天：1,5   每周：1,3  每月： 11,23  每年：0918,1010
//     * @param gatherTimes 归集时点 10:00,11:30,……
//     * @param hourFlag    整点标识 true：整点 false：30分钟
//     * @return 归集Cron表达式
//     */
//    public static String getGatherCron(String periodType, String periodValue, List<String> gatherTimes, boolean hourFlag) {
//        StringBuilder cron = new StringBuilder("0 ")
//                .append(hourFlag ? "30" : "0")
//                .append(" ")
//                .append(getTimes(gatherTimes))
//                .append(" ");
//        switch (periodType) {
//            case "0": //每天
//                cron.append("* * ?");
//                break;
//            case "1": //每月隔天
//                List<String> periodValues = Splitter.on(",").splitToList(periodValue);
//                cron.append(Integer.valueOf(periodValues.get(0)))
//                        .append("/")
//                        .append(Integer.parseInt(periodValues.get(1)) + 1)
//                        .append(" * ?");
//                break;
//            case "2": //每周
//                cron.append("? * ")
//                        .append(getWeekDay(periodValue));
//                break;
//            case "5": //双周
//                cron.append(Integer.valueOf(periodValue)).append("/14 * ?");
//                break;
//            case "3": //每月
//                cron.append(periodValue)
//                        .append(" * ?");
//                break;
//            case "4": //月末
//                cron.append("L * ?");
//                break;
//        }
//        return cron.toString();
//    }
//
//    /**
//     * 由时间点转换为时间 14:00 -> 14
//     *
//     * @param gatherTimes
//     * @return
//     */
//    public static String getTimes(List<String> gatherTimes) {
//        StringBuilder result = new StringBuilder();
//        for (String str : gatherTimes) {
//            result.append(str.split(":")[0] + ",");
//        }
//        return result.toString().substring(0, result.length() - 1);
//    }
//
//    /**
//     * cron里面的1是周日，2是周1
//     *
//     * @param periodValue
//     * @return
//     */
//    public static String getWeekDay(String periodValue) {
//        List<String> list = Splitter.on(',').splitToList(periodValue);
//        List<String> newList = new ArrayList<>();
//        for (String str : list) {
//            int i = Integer.parseInt(str);
//            if (i == 7) {
//                i = 1;
//                newList.add(String.valueOf(i));
//                break;
//            }
//            newList.add(String.valueOf(i + 1));
//        }
//        return Joiner.on(',').join(newList);
//    }
//
//    /**
//     * 每隔14天 cron表达式
//     *
//     * @param oldDate     上次归集日期 或当期交易日期
//     * @param periodValue 周期属性
//     * @return
//     */
//    public static String getAfterFourteenDays(String oldDate, String periodValue) {
//        List<String> list = Splitter.on(',').splitToList(periodValue);
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat plainDateFormat = new SimpleDateFormat("yyyyMMdd");
//        calendar.setTime(plainDateFormat.parse(oldDate, new ParsePosition(0)));
//        calendar.add(Calendar.DATE, 14);
//        System.out.println(plainDateFormat.format(calendar.getTime()).substring(6, 8));
//
//
//        List<String> newList = new ArrayList<>();
//        for (String str : list) {
//            int i = Integer.parseInt(str);
//            if (i == 7) {
//                i = 1;
//                newList.add(String.valueOf(i));
//                break;
//            }
//            newList.add(String.valueOf(i + 1));
//        }
//        return Joiner.on(',').join(newList);
//    }
//}
