package cn.zzy.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 12:05
 * @PackageName:cn.zzy.tools
 * @ClassName: UserInfoPropertiesUtilTest
 * @Description: TODO
 * @Version 1.0
 */
@RunWith(JUnit4.class)
public class UserInfoPropertiesUtilTest {
    @Test
    public void test() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        System.out.println(UserInfoPropertiesUtil.USER_INFO);
    }
}