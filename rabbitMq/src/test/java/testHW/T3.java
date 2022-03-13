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
public class T3 {

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 4, 1, 2, 3};
        // System.out.println(sort(arr));
        // int[] sort = sort(arr);
        // for (int t : sort) {
        //     System.out.println(t);
        // }
        System.out.println(maxWater(arr));
    }

    public long maxWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int low = 0;
        long sum = 0;
        long tmp = 0;
        //从左向右
        for (int i = 0; i < arr.length; i++) {
            if (arr[low] > arr[i]) {
                tmp = tmp + arr[low] - arr[i];
            }
            if (arr[low] <= arr[i]) {
                sum = sum + tmp;
                tmp = 0;
                low = i;
            }
        }
        low = arr.length - 1;
        tmp = 0;
        //从右向左
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[low] > arr[j]) {
                tmp = tmp + arr[low] - arr[j];
            }
            //注意这里不能再 <=，否则可能会重复计算等于的情况
            if (arr[low] < arr[j]) {
                sum = sum + tmp;
                tmp = 0;
                low = j;
            }
        }
        return sum;
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
        return arr;
    }

    private static Integer rain(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp += arr[i] - arr[i + 1];
                for (int j = i + 2; j < arr.length - 1; j++) {
                    if (arr[j - 1] < arr[j]) {
                        if (arr[i] > arr[j]) {
                            temp -= (arr[i] - arr[j]) * (j - i - 1);
                        } else {
                            i = j - 1;
                            break;
                        }
                    } else {
                        temp += arr[i] - arr[j];
                    }
                }

            }
        }
        return temp;
    }
}
