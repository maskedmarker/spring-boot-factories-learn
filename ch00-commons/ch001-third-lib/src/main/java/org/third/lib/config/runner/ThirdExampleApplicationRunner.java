package org.third.lib.config.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class ThirdExampleApplicationRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ThirdExampleApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("{} is working", ThirdExampleApplicationRunner.class.getName());
    }
}
