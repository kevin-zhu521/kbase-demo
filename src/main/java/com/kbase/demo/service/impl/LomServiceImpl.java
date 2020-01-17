package com.kbase.demo.service.impl;

import com.kbase.demo.service.LomService;
import com.kbase.demo.utils.KevinUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author kevin.zhu
 * @date 2020/1/15 17:44
 */
@Service
@Slf4j
public class LomServiceImpl implements LomService {

    @Autowired
    private KevinUtil kevinUtil;

    @PostConstruct
    public void init() {
        log.info("this is LomServiceImpl.init");
    }

    @Override
    @SneakyThrows
    public void test1() {
        String name = kevinUtil.getName();
        System.out.println(name);
        log.info("this is 111111");
    }
}
