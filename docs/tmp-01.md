# spring.factories

默认情况下,classpath下的所有spring.factories中的配置都会被使用.

## autoconfigure的spring.factories

spring-boot-autoconfigure的spring.factories主要定义了如下7类配置.
```text
# Initializers
org.springframework.context.ApplicationContextInitializer

# Application Listeners
org.springframework.context.ApplicationListener

# Auto Configuration Import Listeners
org.springframework.boot.autoconfigure.AutoConfigurationImportListener

# Auto Configuration Import Filters
org.springframework.boot.autoconfigure.AutoConfigurationImportFilter

# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration

# Failure analyzers
org.springframework.boot.diagnostics.FailureAnalyzer

# Template availability providers
org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider
```
注意:
ApplicationContextInitializer/ApplicationListener必须定义在spring.factories文件中.



## EnableAutoConfiguration

默认情况下,spring.factories中的EnableAutoConfiguration都会被自动加载,可用通过@EnableAutoConfiguration.exclude来排除个别不需要被使用的.



## EnvironmentPostProcessor

EnvironmentPostProcessor是在spring容器初始化阶段的早期使用的,必须定义在spring.factories中.
如果EnvironmentPostProcessor定义在了configuration中,虽然也会被注册到了spring容器中,但是错过了容器的初始化阶段,无法触发回调.


# SpringApplicationRunListener
SpringApplicationRunListener也必须定义在spring.factories文件中.