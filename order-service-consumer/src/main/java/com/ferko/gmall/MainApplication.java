package com.ferko.gmall;

import com.ferko.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = context.getBean(OrderService.class);

        orderService.initOrder("1");
        System.out.println("调用完成");

        //线程阻塞一下，不让项目执行完就关闭
        System.in.read();

    }
}
