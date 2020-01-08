package ObjectEqules;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/*********************************************************
 *********************************************************/
public class A implements Serializable {
    private static final long serialVersionUID = -900446427996360676L;
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
