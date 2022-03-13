package test;

import org.junit.Test;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/15 21:11
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest10 {
    @Test
    public void s() {
        char[] a = {'0', '1'};
        char[] b = {'1', '1'};
        char[][] matri = new char[2][2];
        matri[0] = a;
        matri[1] = b;
        solve(matri);
    }

    public int solve(char[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }


}
