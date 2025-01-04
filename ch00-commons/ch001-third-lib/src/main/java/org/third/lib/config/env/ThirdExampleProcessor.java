package org.third.lib.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ThirdExampleProcessor implements EnvironmentPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(ThirdExampleProcessor.class);
    
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        logger.info("{} is working", ThirdExampleProcessor.class.getName());
    }
}
