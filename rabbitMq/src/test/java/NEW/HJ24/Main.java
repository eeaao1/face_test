package NEW.HJ24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW.HJ24
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/14 19:25
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String[] line = br.readLine().split(" ");
        System.out.println(ssMM(line));
    }


    public static int ssMM(String[] line) {
        int h = 1;
        PriorityQueue<D> r = new PriorityQueue(new MyCom());
        boolean f = true;
        boolean ff = false;
        for (int i = 1; i < line.length - 1; i++) {
            if (Integer.valueOf(line[i]) == Integer.valueOf(line[i - 1]) && f) {
                ff = true;
                h++;
                continue;
            }
            if (ff && Integer.valueOf(line[i]) < Integer.valueOf(line[i - 1])) {
                r.add(new D(h));
                h = 1;
                ff = false;
                f = false;
                continue;
            }
            if (Integer.valueOf(line[i]) >= Integer.valueOf(line[i + 1])
                    && Integer.valueOf(line[i - 1]) < Integer.valueOf(line[i])) {
                if (Integer.valueOf(line[i]) == Integer.valueOf(line[i + 1])) {
                    for (int j = i + 1; j < line.length; j++) {
                        if (Integer.valueOf(line[i + 1]) == Integer.valueOf(j)) {
                            h++;
                        } else {
                            break;
                        }
                    }
                    r.add(new D(h));
                    h = 1;
                } else {
                    r.add(new D(1));
                }
            }
        }
        r.poll();
        int rr = 0;
        for (D d : r) {
            rr += d.mun;
        }
        return rr;
    }


    public static class D {
        public int mun;

        public D(int mun) {
            this.mun = mun;
        }
    }


    public static class MyCom implements Comparator<D> {

        @Override
        public int compare(D o1, D o2) {
            return o2.mun - o1.mun;
        }
    }


    public static int ss(String[] line, boolean[] flags, int index) {
        if (check(line, flags)) {
            return 0;
        }
        if (!check(line, flags) && index == flags.length) {
            return -1;
        }
        int r = 0;
        int ss = ss(line, flags, index + 1);
        if (ss == -1) {
            r = Integer.MIN_VALUE;
        } else {
            r += ss;
        }

        int rr = 0;
        flags[index] = true;
        ss = ss(line, flags, index + 1);
        if (ss == -1) {
            r = Integer.MIN_VALUE;
        } else {
            r += ss;
        }
        rr = 1 + ss(line, flags, index + 1);
        flags[index] = false;
        return Math.min(r, rr);
    }


    public static boolean check(String[] line, boolean[] flags) {
        int temp = -1;
        boolean f = false;
        for (int i = 0; i < line.length - 1; i++) {
            if (!flags[i]) {
                if (!f && temp <= Integer.valueOf(line[i + 1])) {
                    temp = Integer.valueOf(line[i]);
                } else if (f && temp <= Integer.valueOf(line[i + 1])) {
                    temp = Integer.valueOf(line[i]);
                } else {
                    if (f) {
                        return false;
                    }
                    f = true;
                    i--;
                }
            }
        }
        return true;
    }

}
