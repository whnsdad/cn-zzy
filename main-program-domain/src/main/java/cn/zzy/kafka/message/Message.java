package cn.zzy.kafka.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/10/12 15:56
 * @Description: TODO
 */
@Data
@Accessors(chain = true)
public class Message {
    public static final String TOPIC = "demo1";

    private Integer id;
}
