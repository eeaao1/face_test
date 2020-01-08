package ObjectEqules;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/*********************************************************
 * 文件名称：A
 * 系统名称：交易银行系统V1.0
 * 模块名称：com.hundsun.tbsp.mbookbiz.service.entity.dto
 * 功能说明：自定义代码dto
 * 开发人员：kongli26489
 * 开发时间：2019/12/17 10:14
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class A implements Serializable {
    private static final long serialVersionUID = -9004464279963160676L;
    /**
     * 账簿编号
     */
    private String a;

    /**
     * 自定义代码
     */
    private String b;

    /**
     * 摘要
     */
    private String c;

    @Override
    public int hashCode() {
        if (StringUtils.isEmpty(b)) {
            return "".hashCode();
        }
        return b.hashCode();
    }

    @Override
    public boolean equals(Object var1) {
        if (!(var1 instanceof A)) {
            return false;
        }
        A dto = (A) var1;
        if (this == dto) {
            return true;
        }
        if (dto.b == null) {
            return Boolean.FALSE;
        }
        return dto.b.equals(this.b);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
