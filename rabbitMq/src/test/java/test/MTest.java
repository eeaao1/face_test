package test;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class MTest {

    @Test
    public void s() {
        System.out.println("123456789".substring(1));
        HashMap<Object, Boolean> objectObjectHashMap = new HashMap<>();
        Set<Object> objects = Collections.newSetFromMap(objectObjectHashMap);
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");
        System.out.println(objectObjectHashMap);
        System.out.println(objects);
    }

    @Test
    public void ss() {

        // System.out.println("./cust_20148281.dat".substring(2));
        // Date date = new Date();
        try {
            System.out.println(InetAddress.getByName("www.baidu.com"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // System.out.println(date.getTime());
    }

    public int[] MySort(int[] arr) {
        int s = arr.length - 1;
        for (int j = 0; j < s; j++) {
            for (int i = 0; i < s - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = t;
                }
            }
        }
        return arr;
    }

    public int[] MySort1(int[] arr) {
        int s = arr.length;
        int temp;
        int minIndex;
        for (int i = 0; i < s - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < s; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public int[] MySort2(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    @Test
    public void lur() {
        int[][] operators = new int[6][3];
        operators[0][0] = 1;
        operators[0][1] = 1;
        operators[0][2] = 1;

        operators[1][0] = 1;
        operators[1][1] = 2;
        operators[1][2] = 2;

        operators[2][0] = 1;
        operators[2][1] = 3;
        operators[2][2] = 2;

        operators[3][0] = 2;
        operators[3][1] = 1;
        // operators[3][2] = 2;

        operators[4][0] = 1;
        operators[4][1] = 4;
        operators[4][2] = 4;

        operators[5][0] = 2;
        operators[5][1] = 2;
        System.out.println(doMain(operators, 3));
    }

    private int[] doMain(int[][] operators, int k) {
        int le = operators.length;
        int r = 0;
        for (int i = 0; i < le; i++) {
            if (operators[i][0] == 2) {
                r++;
            }
        }
        int[] retrun = new int[r];
        int index = 0;
        Integer[][] map = new Integer[k][3];

        for (int i = 0; i < le; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2], map, k);
            } else if (operators[i][0] == 2) {
                retrun[index] = get(operators[i][1], map);
                index++;
            }
        }
        return retrun;
    }

    private void set(int key, int val, Integer[][] map, int k) {
        int delInt = 0;
        int max = -1;
        Boolean isSet = false;
        for (int i = 0; i < k; i++) {
            if (map[i][0] == null || !isSet) {
                map[i][0] = key;
                map[i][1] = val;
                map[i][2] = 0;
                isSet = true;
            } else if (map[i][0] == key) {
                map[i][0] = key;
                map[i][1] = val;
                map[i][2] = 0;
                isSet = true;
            } else {
                map[i][2]++;
                if (max < map[i][2]) {
                    max = map[i][2];
                    delInt = i;
                }
            }
        }
        if (!isSet) {
            map[delInt][0] = key;
            map[delInt][1] = val;
            map[delInt][2] = 0;
        }
    }

    private int get(int k, Integer[][] map) {
        for (int i = 0; i < k; i++) {
            if (map[i][0] == k) {
                map[i][2] = 0;
                return map[i][1];
            } else {
                map[i][2]++;
            }
        }
        return -1;
    }
}
