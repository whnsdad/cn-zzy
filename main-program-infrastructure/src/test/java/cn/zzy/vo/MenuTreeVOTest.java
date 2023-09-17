package cn.zzy.vo;


import cn.zzy.DO.MenuDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/16 22:24
 * @PackageName:cn.zzy.VO
 * @ClassName: MenuTreeVOTest
 * @Description: TODO
 * @Version 1.0
 */
@RunWith(JUnit4.class)
public class MenuTreeVOTest {

    @Test
    public void test() {
        MenuDO menuDO = new MenuDO().setId("1").setName("11");
        MenuTreeVO menuTreeVO = MenuTreeVO.to(menuDO);
        System.out.println(menuTreeVO);
        System.out.println(menuTreeVO.getId());
    }
}