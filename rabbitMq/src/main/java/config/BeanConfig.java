package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.BeanTest;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：config
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/3/25 21:12
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
@Configuration
public class BeanConfig {

    //队列 起名：TestDirectQueue
    @Bean
    public BeanTest TestDirectQueue() {
        BeanTest beanTest = null;
        try {
            beanTest = BeanTest.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // BeanTest beanTest = new BeanTest();
        beanTest.setId("id");
        beanTest.setName("name");

        return beanTest;
    }


}
