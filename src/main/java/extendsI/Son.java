package extendsI;

/*********************************************************
 * 文件名称：Son
 * 系统名称：交易银行系统V1.0
 * 模块名称：extendsI
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/23 16:53
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Son extends Father {
    private String book = "B";

    @Override
    protected void s() {
        System.out.println("S");
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
