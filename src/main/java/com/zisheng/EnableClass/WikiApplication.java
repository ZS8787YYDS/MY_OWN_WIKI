package com.zisheng.EnableClass;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot项目的启动类，默认扫描的范围为当前包及其字包,但是可以加上ComponentScan注解指定所要扫描的包
 */
@SpringBootApplication
@Slf4j
@ComponentScan({"com.zisheng"})
public class WikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiApplication.class, args);
        log.info("SpringBoot项目启动成功！！！");
    }

}
