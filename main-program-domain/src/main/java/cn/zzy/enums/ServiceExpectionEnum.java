package cn.zzy.enums;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/27 9:30
 * @PackageName:cn.zzy.enums
 * @ClassName: ServiceExpectionEnum
 * @Description: TODO
 * @Version 1.0
 */
public enum ServiceExpectionEnum {

    // 服务异常 一共 7 位，分成三段
    // 第一段，1 位，类型
    // 1 - 系统级别异常
    // 2 - 业务级别异常
    // 第二段，3 位，系统类型
    // 001 - 基础系统 base
    // 002 - 用户系统 user
    // 003 - 转账系统 account
    // 004 - 菜单系统 menu
    // ... - ...
    // 第三段，3 位，错误码
    // 不限制规则。 每个系统自增。

    // ========系统级别=========
    SUCCESS(0, "成功"), SYSTEM_ERROR(1000000, "服务端异常"), PARAM_ERROR(1000001, "参数异常"),

    // ========用户系统=========
    USER_NOT_FOUND(2002001, "未找到用户");

    private int code;

    private String message;

    ServiceExpectionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
