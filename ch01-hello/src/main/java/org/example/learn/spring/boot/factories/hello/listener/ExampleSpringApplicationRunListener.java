package org.example.learn.spring.boot.factories.hello.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Listener for the SpringApplication run method.
 * SpringApplicationRunListeners are loaded via the SpringFactoriesLoader
 *      and should declare a public constructor that accepts a SpringApplication instance and a String[] of arguments.
 * A new SpringApplicationRunListener instance will be created for each run.
 */
public class ExampleSpringApplicationRunListener implements SpringApplicationRunListener {

    private static final Logger logger = LoggerFactory.getLogger(ExampleSpringApplicationRunListener.class);

    private final SpringApplication springApplication;
    private final String[] args;

    public ExampleSpringApplicationRunListener(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("environment: {}", Integer.toHexString(environment.hashCode()));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("applicationContext: {}", Integer.toHexString(context.hashCode()));
    }
}
