package cn.zzy.tools;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:53
 * @PackageName:cn.zzy.tools
 * @ClassName: IdGeneratorSnowFlake
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class IdGeneratorSnowFlake {

    private long workerId = 0; // 第几号机房
    private long datacenterId = 1; // 第几号机器
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct // 构造后开始执行，加载初始化工作
    public void init() {
        try {
            // 获取本机的ip地址编码
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId: " + workerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败 ----> " + e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized String snowflakeId() {
        return String.valueOf(snowflake.nextId());
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

}
