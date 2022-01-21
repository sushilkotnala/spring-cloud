package com.sushil.spring.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class OrderClientApplication {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = SpringApplication.run(
                OrderClientApplication.class, args);

        OrderClientController orderClient=ctx.getBean(OrderClientController.class);
        Logger log = LoggerFactory.getLogger(OrderClientApplication.class);

        log.info("Hello");
//        log.info(orderClient.toString());
//        orderClient.getOrder();
//        orderClient.getOrderApiGateway();
//        orderClient.getUser();
//        orderClient.getUserApiGateway();

    }

}