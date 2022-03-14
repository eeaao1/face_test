package NEW.HJ24;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW.HJ24
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/14 20:47
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class kk {
    public static void main(String[] args) {
        int[] m = {5, 10};

        System.out.println(ss(0, 25, m));
    }

    public static int ss(int i, int rest, int[] ms) {
        int n = ms.length;
        if (rest == 0) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        int res = 0;
        int in = 0;
        while (rest - ms[i] * in >= 0) {
            res += ss(i + 1, rest - (ms[i] * in++), ms);
        }
        return res;
    }

    public static int ss1(int i, int rest, int[] ms) {
        int n = ms.length;
        int[][] ress = new int[n][rest];

        if (rest == 0) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        int res = 0;
        int in = 0;
        while (rest - ms[i] * in >= 0) {
            res += ss1(i + 1, rest - (ms[i] * in++), ms);
        }
        return res;
    }
}
