package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pojo.Ball;
import pojo.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

/*********************************************************
 * 文件名称：BeanInfoDemo
 * 系统名称：交易银行系统V1.0
 * 模块名称：spring
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/15 13:42
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
@Component
public class BeanInfoDemo {

//    public static void main(String[] args) throws IntrospectionException {
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
//        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(p -> {
//                    System.out.println(p.getName());
//                }
//        );
//    }

    @Bean
    public Ball ball() {
        Ball ball = new Ball();
        ball.setSize("2");
        ball.setWeight(1);
        return ball;
    }
}
