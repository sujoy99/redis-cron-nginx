package com.starter.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@EnableScheduling
public class RedisApplication {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${jobs.name.enable}")
	private boolean jobEnable;
	@Scheduled(cron = "${cron.expression}")
	public void runEvey15Seconds() {
		if(jobEnable){
			logger.info("LOG:: cron executed");
			LocalTime fromTime = LocalTime.now();
			logger.info("LOG:: fromTime:: " + fromTime);
			logger.info("LOG:: Current time is :: " + LocalDate.now());
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
