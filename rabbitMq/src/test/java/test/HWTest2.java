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
public class HWTest2 {

    private ArrayList<Integer> prev = new ArrayList<>();
    private ArrayList<Integer> mid = new ArrayList<>();
    private ArrayList<Integer> after = new ArrayList<>();

    @Test
    public void lur() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        threeOrders(treeNode1);
    }

    public int[][] threeOrders(TreeNode root) {
        int[][] res = new int[3][];
        prev(root);
        min(root);
        after(root);
        res[0] = prev.stream().mapToInt(Integer::intValue).toArray();
        res[1] = mid.stream().mapToInt(Integer::intValue).toArray();
        res[2] = after.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public void prev(TreeNode node) {
        if (node != null) {
            prev.add(node.val);
            prev(node.left);
            prev(node.right);
        }
    }

    public void min(TreeNode node) {
        if (node != null) {
            min(node.left);
            mid.add(node.val);
            min(node.right);
        }
    }

    public void after(TreeNode node) {
        if (node != null) {
            after(node.left);
            after(node.right);
            after.add(node.val);
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
