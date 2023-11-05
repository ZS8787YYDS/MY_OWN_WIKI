package com.zisheng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot项目的启动类，默认扫描的范围为当前包及其字包,但是可以加上ComponentScan注解指定所要扫描的包
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class WikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiApplication.class, args);
        log.info("SpringBoot项目启动成功！！！");
    }

}
