package testHW;

import org.junit.Test;

import java.util.ArrayList;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：testHW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/16 11:15
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class T2 {

    // 3个数据中心 在某个月份 告警类型 记录在 3个数组中，告警类型为整形，3个数组都是是递增排序
    // 找出3个数据中心 共同数据

    @Test
    public void test() {

        int[] arr1 = {7, 8, 8, 8, 9};
        int[] arr2 = {1, 2, 3, 5, 7, 8, 8, 8, 8, 9};
        int[] arr3 = {7, 8, 8, 8, 8};
        ArrayList<Integer> co = co(arr1, arr2, arr3);
        for (Integer i : co) {
            System.out.println(i);
        }
    }

    private ArrayList<Integer> co(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList<Integer> res = new ArrayList<>();
        int index2 = 0;
        int index3 = 0;
        boolean isSame = false;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        for (int i = 0; i < len1; i++) {
            isSame = false;
            for (int p = index2; p < len2; p++) {
                if (arr1[i] == arr2[p] && !isSame) {
                    index2 = p + 1;
                    for (int q = index3; q < len3; q++) {
                        if (arr1[i] == arr3[q]) {
                            res.add(arr1[i]);
                            index3 = q + 1;
                            isSame = true;
                            break;
                        } else if (arr1[i] > arr3[q]) {
                            index3 = q + 1;
                        } else if (arr1[i] < arr3[q]) {
                            break;
                        }
                    }
                } else if (arr1[i] > arr2[p]) {
                    index2 = p + 1;
                } else if (arr1[i] < arr2[p]) {
                    break;
                }
            }
        }
        return res;
    }

}
