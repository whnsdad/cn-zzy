package cn.zzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.zzy.mapper"})
public class MainProgramBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainProgramBootApplication.class, args);
    }

}
