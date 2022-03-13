package NEW;

import java.util.HashSet;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/12 15:37
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class MunStr {

    public static void main(String[] args) {
        HashSet<String> resM = new HashSet<>();
        int[] muns = {1, 1, 1, 1, 1};
        char[] res = new char[muns.length];
        System.out.println(conver(muns, 0, res, 0, resM));
        System.out.println(conver2(muns, 0));
        System.out.println(conver3(muns));
    }

    public static int conver(int[] muns, int index, char[] res, int resindex, HashSet<String> resM) {
        if (index == muns.length) {
            resM.add(String.valueOf(res));
            return resM.size();
        }
        res[resindex++] = (char) (muns[index++] + 96);
        conver(muns, index, res, resindex, resM);
        resindex--;
        index--;

        if (index + 1 < muns.length && 26 >= (muns[index] * 10 + muns[index + 1])) {
            res[resindex++] = (char) (muns[index] * 10 + muns[index + 1] + 96);
            index += 2;
            conver(muns, index, res, resindex, resM);
            // resindex--;
            // index -= 2;
        }
        return resM.size();
    }

    public static int conver2(int[] muns, int index) {
        if (index == muns.length) {
            return 1;
        }
        if (muns[index] == 0) {
            return 0;
        }
        int i = conver2(muns, index + 1);
        if (index + 1 < muns.length && 26 >= (muns[index] * 10 + muns[index + 1])) {
            i += conver2(muns, index + 2);
        }
        return i;
    }

    public static int conver3(int[] muns) {
        int length = muns.length;
        int[] dp = new int[length + 1];
        dp[length] = 1;
        for (int index = length - 1; index > -1; index--) {
            if (muns[index] == 0) {
                dp[index] = 0;
            }
            dp[index] = dp[index + 1];
            if (index + 1 < muns.length && 26 >= (muns[index] * 10 + muns[index + 1])) {
                dp[index] += dp[index + 2];
            }
        }
        return dp[0];
    }

    public static void bag(int[] w, int[] v, int bag) {


    }
}
