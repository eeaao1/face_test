package testHW;

import org.junit.Test;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：testHW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/16 11:15
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class T4 {

    @Test
    public void test() {

        System.out.println(str1("*)()(())("));
        System.out.println(str1("(()*"));
        System.out.println(str1("*())"));
    }

    public boolean str1(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int left = 0;
        int right = 0;
        int cs = 0;
        for (int i = 0; i < length; i++) {
            if ('(' == chars[i]) {
                left++;
            } else if ('*' == chars[i]) {
                cs++;
            } else {
                if (left == 0) {
                    if (cs > 0) {
                        cs--;
                    } else {
                        return false;
                    }
                } else {
                    left--;
                    if (left < 0) {
                        return false;
                    }
                }
            }
        }
        cs = 0;
        for (int i = length - 1; i > -1; i--) {
            if (')' == chars[i]) {
                right++;
            } else if ('*' == chars[i]) {
                cs++;
            } else {
                if (right == 0) {
                    if (cs > 0) {
                        cs--;
                    } else {
                        return false;
                    }
                } else {
                    right--;
                    if (right < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // public boolean str(String str) {
    //     char[] chars = str.toCharArray();
    //     int length = chars.length;
    //     int left = 0;
    //     int cs = 0;
    //     int[] csIndex = new int[length];
    //     int[] leftIndex = new int[length];
    //
    //     for (int i = 0; i < length; i++) {
    //         if ('(' == chars[i]) {
    //             left++;
    //             leftIndex[i] = 1;
    //         } else if ('*' == chars[i]) {
    //             csIndex[i] = 1;
    //             cs++;
    //         } else {
    //             if (left == 0) {
    //                 if (cs > 0) {
    //                     for (int j = 0; j < length; j++) {
    //                         if (csIndex[j] == 1) {
    //                             csIndex[j] = 0;
    //                             break;
    //                         }
    //                     }
    //                     cs--;
    //                 } else {
    //                     return false;
    //                 }
    //             } else {
    //                 left--;
    //             }
    //             for (int j = 01; j < length; j++) {
    //                 if (leftIndex[j] == 1) {
    //                     leftIndex[j] = 0;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     if (left > 0) {
    //         for (int i = length - 1; i > -1; i--) {
    //             for () {
    //
    //             }
    //             if (csIndex[i] == 1) {
    //                 left--;
    //             }
    //             if (left == 0) {
    //                 break;
    //             }
    //         }
    //     }
    //     return 0 == left;
    // }
}
