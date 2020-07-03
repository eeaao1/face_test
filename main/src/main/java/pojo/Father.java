package pojo;

import org.springframework.stereotype.Component;

/*********************************************************
 * 文件名称：Father
 * 系统名称：交易银行系统V1.0
 * 模块名称：pojo
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/16 16:37
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
@Component
public class Father extends Person {

    private String wife;

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Father{" +
                "wife='" + wife + '\'' +
                "} " + super.toString();
    }
}
