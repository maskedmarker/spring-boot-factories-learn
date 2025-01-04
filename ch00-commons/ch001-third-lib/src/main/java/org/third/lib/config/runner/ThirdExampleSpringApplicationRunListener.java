package org.third.lib.config.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ThirdExampleSpringApplicationRunListener implements SpringApplicationRunListener {

    private static final Logger logger = LoggerFactory.getLogger(ThirdExampleSpringApplicationRunListener.class);

    private final SpringApplication springApplication;
    private final String[] args;

    public ThirdExampleSpringApplicationRunListener(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void starting() {
        logger.info("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logger.info("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        logger.info("started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        logger.info("running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        logger.info("failed");
    }
}
