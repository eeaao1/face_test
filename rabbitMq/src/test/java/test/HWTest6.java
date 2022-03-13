package test;

import org.junit.Test;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest6 {


    @Test
    public void lur() {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(7);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(6);
        ListNode e = new ListNode(3);
        d.next = e;
        addInList(a, d);

    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        head1 = rev(head1);
        head2 = rev(head2);
        ListNode temp = new ListNode(-1);
        ListNode temp1 = null;
        ListNode head = new ListNode(-1);
        boolean a = false;
        while (head1 != null || head2 != null) {
            int val = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + (a ? 1 : 0);
            if (val > 9) {
                a = true;
                val = val - 10;
            } else {
                a = false;
            }
            head.val = val;
            head.next = temp;
            if (temp1 == null) {
                temp1 = head;
            }
            head = temp;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            temp = new ListNode(-1);
        }
        if (a) {
            head.val = 1;
        }
        ListNode rev = rev(temp1);
        if (!a) {
            rev = rev.next;
        }
        return rev;
    }

    public ListNode rev(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode p = null;
        ListNode n = null;
        while (node != null) {
            n = node.next;
            node.next = p;
            p = node;
            node = n;
        }
        return p;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
