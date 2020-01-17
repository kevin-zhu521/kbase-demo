package com.kbase.demo.controller;

import com.kbase.demo.service.LomService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * lombok日志打印测试
 *
 * @author kevin.zhu
 * @date 2020/1/9 10:31
 */
@Slf4j
@RestController
@RequestMapping("lom")
public class lomcontroller {

    @Autowired
    private LomService lomService;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        log.info("this is log");
        lomService.test1();
        log.info("success");
        return ResponseEntity.ok("success");
    }

}
