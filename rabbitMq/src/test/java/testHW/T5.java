package testHW;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：testHW
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/28 13:55
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class T5 {

    @Test
    public void test() {
        Runtime run = Runtime.getRuntime();
        try {
//			Process process = run.exec("cmd.exe /k start " + cmdStr);
            File file = new File("D:\\DOWNLOAD\\new");
            File[] files = file.listFiles();
            for (File f : files) {
                File[] fs = f.listFiles();
                for (File ff : fs) {
                    System.out.println(ff.getAbsolutePath());
                    if (ff.getAbsolutePath().contains(".mp4")) {
                        String cmd2 = "cmd.exe  move  \"" + ff.getAbsolutePath() + "\" D:\\DOWNLOAD\\new";
                        System.out.println(cmd2);
                        BufferedReader br = null;
                        try {
                            Process p = run.exec(cmd2);
                            p.waitFor();
                            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
                            String line = null;
                            StringBuilder sb = new StringBuilder();
                            while ((line = br.readLine()) != null) {
                                sb.append(line + "\n");
                            }
                            System.out.println(sb.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            // if (br != null) {
                            //     try {
                            //         br.close();
                            //     } catch (Exception e) {
                            //         e.printStackTrace();
                            //     }
                            // }
                        }

                        // Process process = run.exec(cmd);
                        // InputStream in = process.getInputStream();
                        // while (in.read() != -1) {
                        //     System.out.println(in.read());
                        // }
                        // in.close();
                        // process.waitFor();
                    }
                }
            }

        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("c:\\windows\\audio\\ffmpeg -i c:\\windows\\audio\\TheBest.mp3");
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            InputStreamReader isr = new InputStreamReader(sis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(process.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            String line = null;
            while (null != (line = br.readLine())) {
                System.out.println(line);

            }
            process.destroy();
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
