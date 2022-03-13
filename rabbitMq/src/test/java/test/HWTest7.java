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
public class HWTest7 {


    @Test
    public void lur() {
        System.out.println(getLongestPalindrome("baabccc", 7));
    }

    public int getLongestPalindrome(String A, int n) {
        // write code here
        char[] arr = A.toCharArray();
        int res = n;
        int c = res;
        int times = 0;
        for (int i = 0; i < n; i++) {
            int end = i + c - 1;
            if (arr[i] != arr[end]) {
                if (end + times == n - 1) {
                    res--;
                    i = -1;
                } else {
                    i -= times;
                }
                c = res;
                times = 0;
            } else {
                if (end -1 == i ||  end -2 == i) {
                    break;
                }
                c -= 2;
                times++;
            }
        }
        return res;
    }
}
