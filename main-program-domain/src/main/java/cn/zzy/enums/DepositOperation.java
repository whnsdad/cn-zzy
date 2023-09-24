package cn.zzy.enums;

import java.util.Objects;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:36
 * @PackageName:cn.zzy.enums
 * @ClassName: AccountOperation
 * @Description: TODO
 * @Version 1.0
 */
public enum DepositOperation {
    INTERNAL(0, "内部转账"), EXTERNAL(1, "外部转账"), SALARY(2, "工资转账");

    private int code;
    private String description;

    DepositOperation(int code) {
        this.code = code;
        assert getByCode(code) != null : "该code值" + code + "不在枚举类之中";
        this.description = getByCode(code).description;
    }

    DepositOperation(String description) {
        assert getByDesc(description) != null : "该description值'" + description + "'不在枚举类之中";
        this.code = getByDesc(description).code;
        this.description = description;
    }

    DepositOperation(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private DepositOperation getByCode(int code) {
        for (DepositOperation operation : values()) {
            if (operation.code == code) {
                return operation;
            }
        }
        return null;
    }

    private DepositOperation getByDesc(String description) {
        for (DepositOperation operation : values()) {
            if (Objects.equals(operation.description, description)) {
                return operation;
            }
        }
        return null;
    }
}
