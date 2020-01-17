package com.kbase.demo.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kevin.zhu
 * @date 2020/1/15 18:50
 */
@Configuration
@ConfigurationProperties("kbs")
@Slf4j
@Data
public class KevinUtil {

    private String name;
    private String age;

    static {
        log.info("this is KevinUtil.static");
    }

    @PostConstruct
    public void init() {
        log.info("this is KevinUtil.init");
    }

    public void get() {
        log.info("this is get");
    }
}
