package cn.zzy.config.knife4j;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Ziyun Zhou
 * @Date: 2023/9/15 20:45
 * @Desc: 文档基础信息
 */
@Data
@Accessors(chain = true)
@Builder
public class Knife4jProperties {
    /**
     * API文档生成基础路径
     */
    private String apiBasePackage;
    /**
     * 是否要启用登录认证
     */
    private boolean enableSecurity;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档描述
     */
    private String description;
    /**
     * 文档版本
     */
    private String version;
    /**
     * 文档联系人姓名
     */
    private String contactName;
    /**
     * 文档联系人网址
     */
    private String contactUrl;
    /**
     * 文档联系人邮箱
     */
    private String contactEmail;

}

