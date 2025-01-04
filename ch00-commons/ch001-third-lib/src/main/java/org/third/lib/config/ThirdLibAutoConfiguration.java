package org.third.lib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.third.lib.config.env.ThirdExampleProcessor;
import org.third.lib.config.runner.ThirdExampleApplicationRunner;

@Configuration(proxyBeanMethods = false)
public class ThirdLibAutoConfiguration {

    /**
     * EnvironmentPostProcessor必须定义在spring.factories中,不然不起作用(虽然也注册到了spring容器中,但是错过了容器的初始化阶段)
     */
/*    @Bean
    public ConfigLocationProcessor configLocationProcessor() {
        return new ConfigLocationProcessor();
    }*/

    @Bean
    public ThirdExampleProcessor thirdExampleProcessor() {
        return new ThirdExampleProcessor();
    }

    @Bean
    public ThirdExampleApplicationRunner thirdExampleApplicationRunner() {
        return new ThirdExampleApplicationRunner();
    }
}
