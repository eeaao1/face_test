package Gamble;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

/*********************************************************
 * 文件名称：GambleResult
 * 系统名称：交易银行系统V1.0
 * 模块名称：Gamble
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2019/12/31 15:02
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class GambleResult {

    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("200000");
        BigDecimal y = BigDecimal.ZERO;
        int s = 9999;
        int c = 0;
        for (int i = 0; i < s; i++) {
            Result v = isV();
            BigDecimal nextAmt = getNextAmt(new BigDecimal(i));
            System.out.print("投入: " + nextAmt);
            c++;
            if (nextAmt.compareTo(b) > 0) {
                System.out.println("");
                System.out.print("破产 " + b + "--" + c);
                return;
            }
            if (v.getV() == 1) {
                System.out.print(" Y ");
                b = b.add(nextAmt);
                s -= i;
                i = -1;
                y = y.add(BigDecimal.ONE);
            } else if (v.getV() == -1) {
                System.out.print(" N ");
                b = b.subtract(nextAmt);
            } else {
                System.out.print(" P ");
                i -= 1;
                s -= 1;
            }
            System.out.println(",小计: " + b);
        }
        System.out.print("最终: " + b + " , 赢 " + y);
    }

    private static Result isV() {
        try {
            // 创建url
            URL realurl = new URL("https://www.baidu.com");
            // 打开连接
            URLConnection connection = realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立连接
            connection.connect();
        } catch (Exception e) {

        }
        Long t = System.currentTimeMillis();
        String st = t.toString();
        int i = Integer.parseInt(st.substring(st.length() - 1));
        Result result = new Result();
        if (i < 3) {
            result.setV(1);
        } else if (i < 7) {
            result.setV(0);
        } else {
            result.setV(-1);
        }
        return result;
    }

    private static BigDecimal getNextAmt(BigDecimal index) {
        BigDecimal d = new BigDecimal(100);
        for (int i = 0; index.compareTo(new BigDecimal(i)) > 0; i++) {
            d = d.multiply(new BigDecimal(2));
        }
        return d;
    }

}
