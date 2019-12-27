package ObjectEqules;

import java.math.BigDecimal;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V1.0
 * 模块名称：Entity
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2019/6/22 10:02
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Person {

    private Person person;
    private String name;

    private BigDecimal age;

    private String mama;

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person(String name, BigDecimal age, String mama) {
        this.name = name;
        this.age = age;
        this.mama = mama;
    }

    public Person(String name, BigDecimal age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", mama='" + mama + '\'' + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getMama() {
        return mama;
    }

    public void setMama(String mama) {
        this.mama = mama;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 17 * result + age.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object var1) {
        if (!(var1 instanceof Person)) {
            return false;
        }
        Person person = (Person) var1;
        if (this == person) {
            return true;
        }
        if (person.mama.equals(this.mama) && person.age.equals(this.age)) {
            return true;
        }
        return false;
    }
}
