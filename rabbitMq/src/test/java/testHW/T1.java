package testHW;

import java.util.ArrayList;
import java.util.Scanner;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：testHW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/16 11:15
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class T1 {

    private static int res = 0;
    private static ArrayList<ArrayList<Integer>> xy = new ArrayList();// X1 X2 Y1 Y2
    // private static int[] x = new int[2];
    // private static int[] y = new int[2];

    //2
    // d 0 2 2 0
    // e -1 1 1 -1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opTimes = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < opTimes; i++) {
            p(sc.nextLine());
        }
        // System.out.println(res);
        // p("d 0 2 2 0");
        // p("e -1 1 1 -1");
        // System.out.println(res);
    }

    public static void p(String str) {
        String[] op = str.split(" ");
        int[] currX = new int[2];
        currX[0] = Integer.parseInt(op[1]);
        currX[1] = Integer.parseInt(op[3]);
        int[] currY = new int[2];
        currY[0] = Integer.parseInt(op[4]);
        currY[1] = Integer.parseInt(op[2]);
        // res = Math.abs(currA[0] - currB[0]) * Math.abs(currA[1] - currB[1]);
        if ("d".equals(op[0])) {
            if (xy == null || xy.size() == 0) {
                ArrayList<Integer> currXY = new ArrayList<>();
                currXY.add(currX[0]);
                currXY.add(currX[1]);
                currXY.add(currY[0]);
                currXY.add(currY[1]);
                xy.add(currXY);
                res = (xy.get(0).get(1) - xy.get(0).get(0)) * (xy.get(0).get(3) - xy.get(0).get(2));
            } else {
                int add = (currX[1] - currX[0]) * (currY[1] - currY[0]);
                res = res + add - compare(currX, currY, true);
            }
        } else if ("e".equals(op[0])) {
            res = res - compare(currX, currY, false);
        }
    }

    public static int compare(int[] currX, int[] currY, boolean isAdd) {
        int change = 0;
        int len = xy.size();
        for (int i = 0; i < len; i++) {
            if (((xy.get(i).get(0) <= currX[0]) && (currX[0] < xy.get(i).get(1)))
                    && ((xy.get(i).get(2) <= currY[0]) && (currY[0] < xy.get(i).get(3)))) {
                change = (xy.get(i).get(1) - currX[0]) * (xy.get(i).get(3) - currY[0]);
                if (isAdd) {
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(currX[0]);
                    new1.add(xy.get(i).get(1));
                    new1.add(xy.get(i).get(3));
                    new1.add(currY[1]);
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(xy.get(i).get(1));
                    new2.add(currX[1]);
                    new2.add(xy.get(i).get(3));
                    new2.add(currY[1]);
                    ArrayList<Integer> new3 = new ArrayList<>();
                    new3.add(xy.get(i).get(1));
                    new3.add(currX[1]);
                    new3.add(currY[0]);
                    new3.add(xy.get(i).get(3));
                    xy.add(new1);
                    xy.add(new2);
                    xy.add(new3);
                } else {
                    xy.get(i).set(1, currX[0]);
                    xy.get(i).set(3, currY[1]);
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(xy.get(i).get(0));
                    new1.add(currX[0]);
                    new1.add(currY[0]);
                    new1.add(xy.get(i).get(3));
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(currX[0]);
                    new2.add(xy.get(i).get(1));
                    new2.add(xy.get(i).get(2));
                    new2.add(currY[0]);
                    xy.add(new1);
                    xy.add(new2);
                }
            } else if (((xy.get(i).get(0) < currX[1]) && (currX[1] <= xy.get(i).get(1)))
                    && ((xy.get(i).get(2) < currY[1]) && (currY[1] <= xy.get(i).get(3)))) {
                change = (xy.get(i).get(1) - currX[1]) * (xy.get(i).get(3) - currY[1]);
                if (isAdd) {
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(currX[0]);
                    new1.add(xy.get(i).get(0));
                    new1.add(currY[0]);
                    new1.add(xy.get(i).get(2));
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(currX[0]);
                    new2.add(xy.get(i).get(0));
                    new2.add(xy.get(i).get(2));
                    new2.add(currY[1]);
                    ArrayList<Integer> new3 = new ArrayList<>();
                    new3.add(xy.get(i).get(0));
                    new3.add(currX[1]);
                    new3.add(currY[0]);
                    new3.add(xy.get(i).get(2));
                    xy.add(new1);
                    xy.add(new2);
                    xy.add(new3);
                } else {
                    xy.get(i).set(0, currX[1]);
                    xy.get(i).set(2, currY[1]);
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(xy.get(i).get(0));
                    new1.add(currX[1]);
                    new1.add(currY[1]);
                    new1.add(xy.get(i).get(3));
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(currX[1]);
                    new2.add(xy.get(i).get(1));
                    new2.add(xy.get(i).get(2));
                    new2.add(currY[1]);
                    xy.add(new1);
                    xy.add(new2);
                }
            } else if (((xy.get(i).get(0) <= currX[1]) && (currX[1] <= xy.get(i).get(1)))
                    && ((xy.get(i).get(2) <= currY[0]) && (currY[0] <= xy.get(i).get(3)))) {
                change = (xy.get(i).get(1) - currX[1]) * (xy.get(i).get(3) - currY[0]);
                if (isAdd) {
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(currX[0]);
                    new1.add(xy.get(i).get(0));
                    new1.add(currY[0]);
                    new1.add(currY[1]);
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(xy.get(i).get(0));
                    new2.add(currX[1]);
                    new2.add(xy.get(i).get(2));
                    new2.add(currY[1]);
                    xy.add(new1);
                    xy.add(new2);
                } else {
                    xy.get(i).set(0, currX[1]);
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(xy.get(i).get(0));
                    new1.add(currX[1]);
                    new1.add(xy.get(i).get(2));
                    new1.add(currY[0]);
                    xy.add(new1);
                }
            } else if (((xy.get(i).get(0) <= currX[0]) && (currX[0] <= xy.get(i).get(1)))
                    && ((xy.get(i).get(2) <= currY[1]) && (currY[1] <= xy.get(i).get(3)))) {
                change = (xy.get(i).get(1) - currX[0]) * (xy.get(i).get(3) - currY[1]);
                if (isAdd) {
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(xy.get(i).get(1));
                    new1.add(currX[1]);
                    new1.add(currY[0]);
                    new1.add(currY[1]);
                    ArrayList<Integer> new2 = new ArrayList<>();
                    new2.add(currX[0]);
                    new2.add(xy.get(i).get(1));
                    new2.add(currY[0]);
                    new2.add(xy.get(i).get(2));
                    xy.add(new1);
                    xy.add(new2);
                } else {
                    xy.get(i).set(1, currX[0]);
                    ArrayList<Integer> new1 = new ArrayList<>();
                    new1.add(currX[0]);
                    new1.add(xy.get(i).get(1));
                    new1.add(currY[1]);
                    new1.add(xy.get(i).get(3));
                    xy.add(new1);
                }
            } else {
                if (isAdd) {
                    ArrayList<Integer> currXY = new ArrayList<>();
                    currXY.add(currX[0]);
                    currXY.add(currX[1]);
                    currXY.add(currY[0]);
                    currXY.add(currY[1]);
                    xy.add(currXY);
                }
            }
        }
        return change;
    }

}
