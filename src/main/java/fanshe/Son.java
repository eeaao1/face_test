package fanshe;

/*********************************************************
 * 文件名称：Son
 * 系统名称：交易银行系统V1.0
 * 模块名称：fanshe
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/6/20 11:40
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Son extends Fa {
    private String son;

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "Son{" +
                "son='" + son + '\'' +
                "} " + super.toString();
    }
}
