package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest3 {


    @Test
    public void lur() {
        int[] arr = {2, 2, 3, 4, 8, 99, 3};
        maxLength(arr);
    }

    public int maxLength(int[] arr) {
        // write code here
        Set<Integer> subArr = new HashSet<>();
        TreeSet<Integer> res = new TreeSet<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (!subArr.add(arr[i])) {
                res.add(subArr.size());
                subArr.clear();
                for (int j = i - 1; -1 < j; j--) {
                    if (arr[i] == arr[j]) {
                        i = j;
                        break;
                    }
                }
            }
        }
        res.add(subArr.size());
        return res.last();
    }

}
