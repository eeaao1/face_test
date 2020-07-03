package lock;

import redis.RedisConection;
import redis.clients.jedis.Jedis;

/*********************************************************
 * 文件名称：ThreadTest
 * 系统名称：交易银行系统V1.0
 * 模块名称：lock
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/3/23 11:29
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class ThreadTest implements Runnable {


    private  Integer i = 100;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        sss();
    }

    private void s() {
        String name = Thread.currentThread().getName();
        Long t = System.currentTimeMillis();
        String st = t.toString();
        int ti = Integer.parseInt(st.substring(st.length() - 1));
        System.out.println("[before], [" + name + "],i= " + i);
        synchronized (this) {
            System.out.println("waiting time = [" + (System.currentTimeMillis() - t) + "]ms, [" + name + "]");
            if (i == 100) {
                try {
                    Thread.sleep(ti);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i = i - 100;
            }
        }
        System.out.println("[after], [" + name + "],i= " + i);
    }

    private synchronized void ss() {
        String name = Thread.currentThread().getName();
        Long t = System.currentTimeMillis();
        String st = t.toString();
        int ti = Integer.parseInt(st.substring(st.length() - 1));
        System.out.println("[before], [" + name + "],i= " + i);
        if (i == 100) {
            System.out.println("waiting time = [" + (System.currentTimeMillis() - t) + "]ms, [" + name + "]");
            try {
                Thread.sleep(ti);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i - 100;
        }
        System.out.println("[after], [" + name + "],i= " + i);
    }

    private void sss() {
        String name = Thread.currentThread().getName();
        Long t = System.currentTimeMillis();
        String st = t.toString();
        int ti = Integer.parseInt(st.substring(st.length() - 1));
        System.out.println("[before], [" + name + "],i= " + i);
        if (i == 100) {
            try {
                Thread.sleep(ti);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i - 100;
        }
        System.out.println("[after], [" + name + "],i= " + i);
    }

    private void redisLock() {
        String name = Thread.currentThread().getName();
        Long t = System.currentTimeMillis();
        String st = t.toString();
        int ti = Integer.parseInt(st.substring(st.length() - 1));
        System.out.println("[before], [" + name + "],i= " + i);
        if (i == 100) {
            System.out.println("waiting time = [" + (System.currentTimeMillis() - t) + "]ms, [" + name + "]");
            try {
                Thread.sleep(ti);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i - 100;
        }
        System.out.println("[after], [" + name + "],i= " + i);
    }
}
