package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest4 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<TreeNode> layer = new ArrayList<>();

    @Test
    public void lur() {
        TreeNode treeNode = new TreeNode(1, null, null);
        zigzagLevelOrder(treeNode);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<Integer> item = new ArrayList<>();
        if (root != null) {
            layer.add(root);
            ss();
        }
        return res;
    }


    public void ss() {
        boolean isAdd = false;
        // left
        ArrayList<Integer> re = new ArrayList<>();
        // layer.stream().map(node -> node.val).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<TreeNode> nextLayer = new ArrayList<>();
        Collections.reverse(layer);
        for (TreeNode t : layer) {
            if (res.size() % 2 == 0) {
                if (t != null) {
                    re.add(t.val);
                    nextLayer.add(t.left);
                    nextLayer.add(t.right);
                    isAdd = true;
                }
            } else {
                if (t != null) {
                    re.add(t.val);
                    nextLayer.add(t.right);
                    nextLayer.add(t.left);
                    isAdd = true;
                }
            }
        }
        if (isAdd) {
            layer = nextLayer;
            res.add(re);
            ss();
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
