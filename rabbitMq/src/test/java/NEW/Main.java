package NEW;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int money = s.nextInt();
        int count = s.nextInt();
        Good[] mgoods = new Good[count];
        Good[] fgoods = new Good[count];
        int mindex = 0;
        int findex = 0;
        HashMap<Integer, Good> goods = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int value = s.nextInt();
            int weight = s.nextInt();
            int no = s.nextInt();
            if (no == 0) {
                mgoods[mindex] = new Good(value, true, weight, i + 1);
                goods.put(i + 1, mgoods[mindex]);
                mindex++;
            } else {
                fgoods[findex] = new Good(value, false, weight, no);
                findex++;
            }
        }
        for (int i = 0; mindex + i < mgoods.length; i++) {
            mgoods[mindex + i] = fgoods[i];
            if (goods.containsKey(fgoods[i].no)) {
                if (goods.get(fgoods[i].no).a1 == 0) {
                    goods.get(fgoods[i].no).a1 = mindex + i;
                } else {
                    goods.get(fgoods[i].no).a2 = mindex + i;
                }
            }
        }
        // System.out.println(ss(money, mgoods, new HashMap<Integer, Integer>(), 0, new HashMap<String, Integer>()));
        // System.out.println(ss2(money, mgoods, new HashMap<Integer, Integer>()));
        // System.out.println(ss1(money, mgoods, 0, findex));
        System.out.println(ss1DP(money, mgoods, findex));
    }


    public static int ss(int money, Good[] goods, HashMap<Integer, Integer> buyeds, int index) {
        if (money <= 0) {
            return 0;
        }
        if (index == goods.length) {
            return 0;
        }
        int p2 = Integer.MIN_VALUE;
        if (money - goods[index].value >= 0 &&
                (goods[index].isM || (buyeds.containsKey(goods[index].no) && buyeds.get(goods[index].no) > 0))) {
            if (goods[index].isM) {
                mbuyed(buyeds, goods[index].no, true);
            }
            p2 = goods[index].value * goods[index].weight + ss(money - goods[index].value, goods, buyeds, index + 1);
            if (goods[index].isM) {
                mbuyed(buyeds, goods[index].no, false);
            }
        }
        int p1 = ss(money, goods, buyeds, index + 1);
        return Math.max(p1, p2);
    }

    public static int ss1(int money, Good[] goods, int index, int findex) {
        if (money <= 0) {
            return 0;
        }
        if (index == goods.length - findex) {
            return 0;
        }
        int p2 = Integer.MIN_VALUE;
        int p3 = Integer.MIN_VALUE;
        int p4 = Integer.MIN_VALUE;
        int p5 = Integer.MIN_VALUE;
        int mv = goods[index].value;
        if (money - mv >= 0) {
            p2 = mv * goods[index].weight + ss1(money - mv, goods, index + 1, findex);
        }
        int a1v = goods[goods[index].a1].value;
        if (goods[index].a1 != 0) {
            if (money - mv - a1v >= 0) {
                p3 = mv * goods[index].weight + a1v * goods[goods[index].a1].weight +
                        ss1(money - goods[index].value - a1v, goods, index + 1, findex);
            }
        }
        int a2v = goods[goods[index].a2].value;
        if (goods[index].a2 != 0) {
            if (money - mv - a2v >= 0) {
                p4 = mv * goods[index].weight + a2v * goods[goods[index].a2].weight +
                        ss1(money - goods[index].value - a2v, goods, index + 1, findex);
            }
        }
        if (goods[index].a2 != 0 && goods[index].a1 != 0) {
            if (money - mv - a1v - a2v >= 0) {
                p5 = mv * goods[index].weight + a1v * goods[goods[index].a1].weight + a2v * goods[goods[index].a2].weight +
                        ss1(money - goods[index].value - a1v - a2v, goods, index + 1, findex);
            }
        }
        int p1 = ss1(money, goods, index + 1, findex);
        return Math.max(Math.max(Math.max(Math.max(p1, p2), p3), p4), p5);
    }

    public static int ss1DP(int mone, Good[] goods, int findex) {
        int n = goods.length;
        int[][] dp = new int[n + 1 - findex][mone + 1];
        for (int index = 0; index < n + 1 - findex; index++) {
            for (int money = 0; money <= mone; money++) {
                if (money <= 0) {
                    dp[index][0] = 0;
                }
                if (index == goods.length - findex) {
                    dp[goods.length - findex][money] = 0;
                }
                int mv = goods[index].value;
                if (money - mv >= 0) {
                    dp[index][money] = mv * goods[index].weight + dp[index + 1][money - mv];
                }
                int a1v = goods[goods[index].a1].value;
                if (goods[index].a1 != 0) {
                    if (money - mv - a1v >= 0) {
                        dp[index][money] = mv * goods[index].weight + a1v * goods[goods[index].a1].weight +
                                dp[index + 1][money - goods[index].value - a1v];
                    }
                }
                int a2v = goods[goods[index].a2].value;
                if (goods[index].a2 != 0) {
                    if (money - mv - a2v >= 0) {
                        dp[index][money] = mv * goods[index].weight + a2v * goods[goods[index].a2].weight +
                                dp[index + 1][money - goods[index].value - a2v];
                    }
                }
                if (goods[index].a2 != 0 && goods[index].a1 != 0) {
                    if (money - mv - a1v - a2v >= 0) {
                        dp[index][money] = mv * goods[index].weight + a1v * goods[goods[index].a1].weight + a2v * goods[goods[index].a2].weight +
                                dp[index + 1][money - goods[index].value - a1v - a2v];
                    }
                }
                dp[index][money] = dp[index + 1][money];
            }
        }
        return dp[n + 1 - findex][mone];
    }

    public static int ss2(int money, Good[] goods, HashMap<Integer, Integer> buyeds) {
        int N = goods.length;
        int[][] dp = new int[N + 1][money + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= money; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest >= goods[index].value) {
                    dp[index][rest] = Math.max(dp[index][rest],
                            goods[index].value * goods[index].weight + dp[index + 1][rest - goods[index].value]);
                }
            }
        }
        return dp[0][money];
    }


    public static void mbuyed(HashMap<Integer, Integer> buyeds, int no, boolean buy) {
        if (buy) {
            if (buyeds.containsKey(no)) {
                buyeds.put(no, buyeds.get(no) + 1);
            } else {
                buyeds.put(no, 1);
            }
        } else {
            buyeds.put(no, buyeds.get(no) - 1);
        }

    }
}

class Good {
    public int value;
    public boolean isM;
    public int weight;
    public int no;
    public int a1;
    public int a2;

    public Good(int value, boolean isM, int weight, int no) {
        this.value = value;
        this.isM = isM;
        this.weight = weight;
        this.no = no;
    }
}
