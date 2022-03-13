package test;

import org.junit.Test;

import java.util.ArrayList;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest8 {


    @Test
    public void lur() {
        int[] r = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        LIS(r);
    }

    public int[] LIS(int[] arr) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> re = new ArrayList<>();
            re.add(arr[i]);
            int t = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[t] < arr[j]) {
                    re.add(arr[j]);
                    t = j;
                } else {

                }
            }
            if (res.size() <= re.size()) {
                res.add(re);
            }
        }
        // return res.stream().mapToInt(Integer::intValue).toArray();
        return null;
    }

    public int sum(ArrayList<Integer> re) {
        return re.stream().mapToInt(Integer::intValue).sum();
    }

    // public int lengthOfLIS(int[] nums) {
    //     //边界条件判断
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int[] dp = new int[nums.length];
    //     //初始化数组dp的每个值为1
    //     Arrays.fill(dp, 1);
    //     int max = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             //如果当前值nums[i]大于nums[j]，说明nums[i]可以和
    //             //nums[j]结尾的上升序列构成一个新的上升子序列
    //             if (nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //                 //记录构成的最大值
    //                 max = Math.max(max, dp[i]);
    //             }
    //         }
    //     }
    //     return max;
    // }

}
