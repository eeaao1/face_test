package spring;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pojo.Ball;
import pojo.Person;

import java.util.Map;
import java.util.Map.Entry;

/*********************************************************
 * 文件名称：LookUp
 * 系统名称：交易银行系统V1.0
 * 模块名称：spring
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/16 16:37
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
@Component
public class LookUp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
        app.scan(LookUp.class.getPackage().getName());
        app.refresh();
        ListableBeanFactory lb = (ListableBeanFactory) app;
        Map<String, Person> beansOfType = lb.getBeansOfType(Person.class);
        for (Entry s :beansOfType.entrySet()){
            System.out.println(s);
        }
        Map<String, Ball> beansOfType1 = lb.getBeansOfType(Ball.class);
        for (Entry s :beansOfType1.entrySet()){
            System.out.println(s);
        }
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setAge(1);
        person.setName("lala");
        return person;
    }
}
