//package autodeploy;
//
//import net.neoremind.sshxcute.core.ConnBean;
//import net.neoremind.sshxcute.core.Result;
//import net.neoremind.sshxcute.core.SSHExec;
//import net.neoremind.sshxcute.task.CustomTask;
//import net.neoremind.sshxcute.task.impl.ExecCommand;
//
///*********************************************************
// * 文件名称：AutoDeploy
// * 系统名称：交易银行系统V1.0
// * 模块名称：Entity.entity005
// * 功能说明：${TODO}
// * 开发人员：kongli26489
// * 开发时间：2019/12/17 11:44
// * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
// *********************************************************/
//public class AutoDeploy {
//
//    //    private final static String cmpPath = "E:\\ddd\\tbsp-cmpbiz-5.0.2-SNAPSHOT.jar";
//    private final static String cmpPath = "E:\\ddd\\delete.sh";
//    private final static String inPath = "E:\\code\\tbsp-cmpbiz5.0\\tbsp-cmpbiz-deploy\\target\\tbsp-app\\tbsp-app\\tbsp-cmpbiz-5.0.2-SNAPSHOT.jar";
//    private final static String outPath = "E:\\code\\tbsp-cmpbiz5.0\\tbsp-cmpbiz-deploy\\target\\tbsp-app\\tbsp-app\\tbsp-cmpbiz-5.0.2-SNAPSHOT.jar";
//
//    public static void main(String[] args) throws Exception {
//        connect();
//    }
//
//    private static void connect() throws Exception {
//        // 新建一个 ConnBean 对象，三个参数依次是 ip 地址、用户名、密码
//        ConnBean cb = new ConnBean("10.20.25.197", "cfsp", "cfsp@123");
//        // 将上面新建的 ConnBean 作为参数传递给 SSHExec 的静态单例方法，得到一个 SSHExec 的实例
//        SSHExec ssh = SSHExec.getInstance(cb);
//        // 利用上面得到的 SSHExec 实例连接主机
//        ssh.connect();
//        ssh.uploadSingleDataToServer(cmpPath, "/home/cfsp/tbsp-cmpbiz/tbsp-app");
//        CustomTask ct1 = new ExecCommand("/home/cfsp/tbsp-cmpbiz/tbsp-app/stop.sh");
//        Result exec = ssh.exec(ct1);
//        if (exec.isSuccess) {
//            System.out.println("stop Return code: " + exec.rc);
//            System.out.println("stop sysout: " + exec.sysout);
//            CustomTask ct2 = new ExecCommand("/home/cfsp/tbsp-cmpbiz/tbsp-app/start.sh");
//            Result exec2 = ssh.exec(ct2);
//            if (exec2.isSuccess) {
//                System.out.println("start Return code: " + exec2.rc);
//                System.out.println("start sysout: " + exec2.sysout);
//            } else {
//                System.out.println("start Return code: " + exec2.rc);
//                System.out.println("start error message: " + exec2.error_msg);
//            }
//        } else {
//            System.out.println("stop Return code: " + exec.rc);
//            System.out.println("stop error message: " + exec.error_msg);
//        }
//        ssh.disconnect();
//    }
//
////    private static void build(Runtime run) throws IOException, InterruptedException {
////        /**
////         * cmd /c dir 是执行完dir命令后关闭命令窗口。
////         * cmd /k dir 是执行完dir命令后不关闭命令窗口。
////         *
////         * cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
////         * cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。
////         */
////        List<String> commands = new ArrayList<>();
//////        commands.add("cmd /k cmd.exe /k");
////        commands.add("E:\\ddd\\build.bat");
////        ProcessBuilder pb = new ProcessBuilder(commands);
////        //可以修改进程环境变量
//////        pb.environment().put("DAXIN_HOME", "/home/daxin");
//////        System.out.println(pb.directory());
////        Process process = pb.start();
////        int status = process.waitFor();
////        System.out.println(status);
////        System.out.println(getResult(process));
////    }
////
////
////    private static String getResult(Process p) throws InterruptedException {
////        StringBuilder builder = new StringBuilder();
////        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gb2312"))) {
////            String readLine = br.readLine();
////            while (readLine != null) {
////                readLine = br.readLine();
////                builder.append(readLine);
////            }
////            p.waitFor();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return builder.toString();
////    }
//}
