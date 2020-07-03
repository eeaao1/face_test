package cron;

/*********************************************************
 * 文件名称：G00217
 * 系统名称：交易银行系统V1.0
 * 模块名称：cron
 * 功能说明：${TODO}
 * 开发人员：kongli26489
 * 开发时间：2020/6/22 18:43
 * 修改记录：程序版本	修改日期	修改人员	修改单号	修改说明
 *********************************************************/
public enum G00217 {
    EVERY_DAY("G00217", "0", "每天"),
    NEXT_DAY("G00217", "1", "隔天"),
    WEEKLY("G00217", "2", "单周"),
    MONTHLY("G00217", "3", "每月"),
    END_MONTH("G00217", "4", "月末"),
    DOUBLE_WEEKLY("G00217", "5", "双周"),
    USER_DEFINED("G00217", "10", "每年");

    private String dictId;
    private String code;
    private String description;

    public String getDictId() {
        return this.dictId;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    private G00217(String dictId, String code, String description) {
        this.dictId = dictId;
        this.code = code;
        this.description = description;
    }
}
