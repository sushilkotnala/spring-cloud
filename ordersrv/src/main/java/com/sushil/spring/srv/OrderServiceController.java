package com.sushil.spring.srv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

    @Autowired
    private Environment env;

    Logger log = LoggerFactory.getLogger(OrderServiceController.class);

    @RequestMapping(value = "/order/listOrders", method = RequestMethod.GET)
    public Order orders() {

        log.info("Name >>>>> " + env.getProperty("name"));
        Order ord = new Order();
        ord.setId(123);

       return ord;
    }
}
