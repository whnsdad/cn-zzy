package cn.zzy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.concurrent.ListenableFutureCallback;

import cn.zzy.kafka.DemoProducer;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // 自动配置mockMvc实现自动注入
@Slf4j
class MainProgramBootApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void MockMvcTest() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/pattern/test/type1"));
        actions.andExpect(MockMvcResultMatchers.status().isOk()); // 校验响应码200
        actions.andDo(MockMvcResultHandlers.print()); // 打印输出
    }

    @Autowired
    private DemoProducer producer;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        int id = (int)(System.currentTimeMillis() / 1000);
        SendResult result = producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int)(System.currentTimeMillis() / 1000);
        producer.asyncSend(id).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, ex);
            }

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                log.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, result);
            }
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
