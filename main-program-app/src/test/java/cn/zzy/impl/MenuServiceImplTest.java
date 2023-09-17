package cn.zzy.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 11:11
 * @PackageName:cn.zzy.impl
 * @ClassName: MenuServiceImplTest
 * @Description: TODO
 * @Version 1.0
 */

@RunWith(JUnit4.class)
public class MenuServiceImplTest {
    @Test
    public void test() {
        String s = "[{\"id\":1,\"parentId\":0,\"children\":[{\"id\":3,\"parentId\":1,\"children\":[]}]},{\"id\":2,\"parentId\":0,\"children\":[{\"id\":4,\"parentId\":2,\"children\":[{\"id\":5,\"parentId\":4,\"children\":[]}]}]}]";

        try {
            JSONArray jsonArray = JSON.parseArray(s); // 解析为JSONArray
            for (Object obj : jsonArray) {
                if (obj instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) obj;
                    System.out.println(jsonObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}