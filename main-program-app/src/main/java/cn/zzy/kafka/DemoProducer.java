package cn.zzy.kafka;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import cn.zzy.kafka.message.Message;

/**
 * @Author Ziyun Zhou
 * @Date 2023/10/12 16:01
 * @Description: TODO
 */
@Component
public class DemoProducer {
    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult<Object, Object> syncSend(Integer id) throws ExecutionException, InterruptedException {
        Message message = new Message().setId(id);
        return kafkaTemplate.send(Message.TOPIC, message).get();
    }

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id) {
        Message message = new Message().setId(id);
        return kafkaTemplate.send(Message.TOPIC, message);
    }
}
