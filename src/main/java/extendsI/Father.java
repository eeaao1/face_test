package extendsI;

/*********************************************************
 * 文件名称：Father
 * 系统名称：交易银行系统V1.0
 * 模块名称：extendsI
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/23 16:53
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Father {
    private String name = "F";
    private String car = "C";

    public void talk() {
        System.out.println("Father:" + this.getClass() + ",name:" + name + ",car:" + car);
        s();
    }

    protected void s() {
        System.out.println("F");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
