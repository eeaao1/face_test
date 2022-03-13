package test;

import org.junit.Test;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest5 {


    @Test
    public void lur() {
        System.out.println(LCS("1AB2345CD", "12345EF"));
    }

    public String LCS(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int maxLen = 0;
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    temp.append(str2.charAt(j));
                } else {
                    if (maxLen < temp.length()) {
                        maxLen = temp.length();
                        res = temp;
                    }
                    temp = new StringBuilder();
                }
            }
        }
        return res.toString();
    }

    public String LCS1(String str1, String str2) {
        String res = "";
        int s = 0;
        int e = 1;
        int length2 = str2.length();
        while (e < length2 + 1) {
            String substring = str2.substring(s, e);
            if (str1.contains(substring)) {
                if (substring.length() > res.length()) {
                    res = substring;
                }
                e++;
            } else {
                s++;
                e = s + 1;
            }
        }
        return res;
    }

}
