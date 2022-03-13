package NEW.Ob;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW.Ob
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/4 22:35
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class Node {


    public int value;

    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
