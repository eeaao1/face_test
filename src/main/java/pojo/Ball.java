package pojo;

/*********************************************************
 * 文件名称：Ball
 * 系统名称：交易银行系统V1.0
 * 模块名称：pojo
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/20 20:34
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Ball {

    private String size;

    private Integer weight;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}
