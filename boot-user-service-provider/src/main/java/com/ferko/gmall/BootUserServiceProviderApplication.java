package com.ferko.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.将服务提供者注册到注册中心
 * 		1）导入dubbo-boot-starter (自动引入dubbo依赖 \ 操作 zookeeper 的客户端)
 * 		2）配置服务提供者（ @Service 注解的方式 暴露服务）
 * 	    3）在springbootapplication 注解 @EnableDubbo 开启 dubbo 功能
 *
 * SpringBoot 与 Dubbo 整合的三种方式
 * 1. 导入 dubbo-boot-starter,在application.properties 配置属性，使用@Service【暴露服务】，使用@Reference【引用服务】，配合@EnableDubbo
 * 2. 保留dubbo配置文件 可以精确到方法级别，引入dubbo-boot-starter，在 SpringBootApplication 搭配@ImportReasource(“对应的dubbo.xml配置文件”)
 * 3. 配置类
 *
 */
@EnableDubbo //开启基于注解的Dubbo功能
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
