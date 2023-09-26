package cn.zzy;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // 自动配置mockMvc实现自动注入
class MainProgramBootApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void MockMvcTest() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/pattern/test/type1"));
        actions.andExpect(MockMvcResultMatchers.status().isOk()); // 校验响应码200
        actions.andDo(MockMvcResultHandlers.print()); // 打印输出
    }

}
