package pojo;

/*********************************************************
 * 文件名称：Person
 * 系统名称：交易银行系统V1.0
 * 模块名称：pojo
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/15 13:45
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Person {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
