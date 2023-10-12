package cn.zzy.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cn.zzy.kafka.message.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/10/12 16:05
 * @Description: TODO
 */
@Component
@Slf4j
public class DemoConsumer {
    @KafkaListener(topics = Message.TOPIC, groupId = "demo1-consumer-group-" + Message.TOPIC)
    public void onListener(Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
