package NEW;

import NEW.Ob.Node;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：NEW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2022/3/4 21:21
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class Test {
    public static void main(String[] args) {
        // Node n1 = new Node(1);
        // Node n2 = new Node(2);
        // Node n3 = new Node(3);
        // Node n4 = new Node(4);
        // Node n5 = new Node(5);
        // Node n6 = new Node(6);
        // Node n7 = new Node(7);
        // n1.next=n2;
        // n2.next=n3;
        // n3.next=n4;
        // n4.next=n5;
        // n5.next=n6;
        // n6.next=n7;
        // plint(n1);
        // System.out.println("");
        // plint(Node.reverseLinkList(n1));
        Thread thread = Thread.currentThread();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (; ; ) {

                }
            }
        };
        // thread1.start();
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        try {
            thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void plint(Node n) {
        while (n != null) {
            System.out.print(n.value + ",");
            n = n.next;
        }

    }
}
