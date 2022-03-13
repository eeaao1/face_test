package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/29 17:56
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;

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
        System.out.println(LRU(operators, 3));
    }

    public int[] LRU(int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }

    private void set(int key, int val) {
        if (map.containsKey(key)) {
            map.get(k).val = val;
        } else if (map.size() == k) {
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.prev.next = tail;
        }
        Node node = new Node(key, val);
        moveToHead(node);
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
