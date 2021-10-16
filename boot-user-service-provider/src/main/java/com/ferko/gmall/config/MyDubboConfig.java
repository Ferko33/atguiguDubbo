package com.ferko.gmall.config;

import com.ferko.gmall.service.UserService;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig =  new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("192.168.100.101:2181");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        return protocolConfig;
    }

    public ServiceConfig<UserService> userServiceConfig(UserService userService){
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setInterface(UserService.class);
        userServiceConfig.setRef(userService);
        userServiceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(5000);

        //将method的设置保存到service中
        List<MethodConfig> methodConfigs = new ArrayList<>();
        methodConfigs.add(methodConfig);
        userServiceConfig.setMethods(methodConfigs);

        return userServiceConfig;
    }
}
