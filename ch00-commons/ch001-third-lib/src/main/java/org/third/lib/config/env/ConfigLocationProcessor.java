package org.third.lib.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class ConfigLocationProcessor implements EnvironmentPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLocationProcessor.class);

    // class path路径
    public static final String CONFIG_LOCATION_KEY = "configLocation";
    public static final Pattern pattern = Pattern.compile("\\s*[,]+\\s*");
    
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 没有配置就忽略
        String propValue = environment.getProperty(CONFIG_LOCATION_KEY);
        if (StringUtils.isEmpty(propValue)) {
            logger.info("{}配置为空", CONFIG_LOCATION_KEY);
            return;
        }

        Map<String, Object> map = loadPropertyFromClassPath(propValue);
        MapPropertySource configLocationPropertySource = new MapPropertySource("configLocationPropertySource", map);
        environment.getPropertySources().addFirst(configLocationPropertySource);
    }

    private Map<String, Object> loadPropertyFromClassPath(String locations) {
        Map<String, Object> map = new HashMap<>();
        String[] locationArray = pattern.split(locations);
        for (String location : locationArray) {
            try {
                logger.info("开始读取classpath下的配置文件: {}", location);
                Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource(location), StandardCharsets.UTF_8));
                properties.forEach((k, v) -> {
                    map.put((String) k, v);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return map;
    }
}
