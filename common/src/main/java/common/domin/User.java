package common.domin;

import lombok.Data;

import java.io.Serializable;

/*********************************************************
 * 文件名称：User
 * 系统名称：交易银行系统V1.0
 * 模块名称：common.domin
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/1/7 16:09
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1857327156072168608L;

    private int id;

    private  String name;

    private  int age;

    private String sex;
}
