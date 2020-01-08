package ObjectEqules;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/*********************************************************
 * 文件名称：SummaryCodeDTO
 * 系统名称：交易银行系统V1.0
 * 模块名称：com.hundsun.tbsp.mbookbiz.service.entity.dto
 * 功能说明：自定义代码dto
 * 开发人员：kongli26489
 * 开发时间：2019/12/17 10:14
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class SummaryCodeDTO implements Serializable {
    private static final long serialVersionUID = -9004464279963160676L;
    /**
     * 账簿编号
     */
    private String asacNo;

    /**
     * 自定义代码
     */
    private String defineCode;

    /**
     * 摘要
     */
    private String summary;

    @Override
    public int hashCode() {
        if (StringUtils.isEmpty(defineCode)) {
            return "".hashCode();
        }
        return defineCode.hashCode();
    }

    @Override
    public boolean equals(Object var1) {
        if (!(var1 instanceof SummaryCodeDTO)) {
            return false;
        }
        SummaryCodeDTO dto = (SummaryCodeDTO) var1;
        if (this == dto) {
            return true;
        }
        if (dto.defineCode == null) {
            return Boolean.FALSE;
        }
        return dto.defineCode.equals(this.defineCode);
    }

    public String getAsacNo() {
        return asacNo;
    }

    public void setAsacNo(String asacNo) {
        this.asacNo = asacNo;
    }

    public String getDefineCode() {
        return defineCode;
    }

    public void setDefineCode(String defineCode) {
        this.defineCode = defineCode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
