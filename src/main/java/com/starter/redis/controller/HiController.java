package com.starter.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

@RestController
public class HiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String hi(HttpServletRequest request) {
        logger.info("LOG::this is from " + request.getRequestURL().toString());
        LocalTime fromTime = LocalTime.now();
        logger.info("LOG:: fromTime in controller:: " + fromTime);
        logger.info("LOG::this is session " + request.getRequestedSessionId());
        return "hello world";
    }
}
