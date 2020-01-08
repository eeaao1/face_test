package provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/*********************************************************
 * 文件名称：ProviderApplication
 * 系统名称：交易银行系统V1.0
 * 模块名称：provider
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/1/7 16:32
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
//@MapperScan("mapper")
public class ProviderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProviderApplication.class, args);
        System.out.println("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
