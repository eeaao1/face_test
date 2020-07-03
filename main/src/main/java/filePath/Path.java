package filePath;

/*********************************************************
 * 文件名称：Path
 * 系统名称：交易银行系统V1.0
 * 模块名称：filePath
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/4/20 20:27
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public class Path {
    public static void main(String[] args) {
        String file = Path.class.getClassLoader().getResource(Path.class.getPackage().getName().replace(".", "/")).getFile();
        System.out.println(Path.class.getClassLoader().getResource(Path.class.getPackage().getName()));
    }
}
