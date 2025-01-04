package org.example.learn.spring.boot.factories.hello.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * ApplicationPreparedEvent -> ApplicationReadyEvent
 * 如果不通过spring.factories来注册ApplicationListener来监听spring容器的早期事件(比如:ApplicationPreparedEvent),是无效的.
 * 通过@Component只能监听到较后期的事件
 *
 */
@Component
public class ConfigLocationTester implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLocationTester.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        String fooValue = environment.getProperty("foo");
        logger.info("fooValue: {}", fooValue);
    }
}
