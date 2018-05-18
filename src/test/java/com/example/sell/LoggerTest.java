package com.example.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    //private final org.slf4j.Logger logger=LoggerFactory.getLogger(SellApplication.class);
    //用logger.debug()等
    @Test
    public void test1(){
        String name = "ahhh";
        String passwd = "hhha";
        log.debug("debug..");
        log.info("name:{} ,passwd: {}",name,passwd);
        log.error("error...");
        log.warn("warn~~~~~~~~~~");
    }
}
