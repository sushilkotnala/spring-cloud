package com.sushil.spring.client;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Controller
public class OrderClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    Logger log = LoggerFactory.getLogger(OrderClientController.class);

    public void getOrder() throws RestClientException, IOException {
        List<ServiceInstance> instances=discoveryClient.getInstances("orderservice");
        ServiceInstance serviceInstance=instances.get(0);

        String baseUrl=serviceInstance.getUri().toString();

        baseUrl=baseUrl+"/order/listOrders";
        log.info("baseurl "+ baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),String.class);
        } catch (Exception ex) {
            log.error("Exception >", ex);
        }
        log.info(response.getBody());
    }


    public void getUser() throws RestClientException, IOException {
        List<ServiceInstance> instances=discoveryClient.getInstances("userservice");
        ServiceInstance serviceInstance=instances.get(0);

        String baseUrl=serviceInstance.getUri().toString();

        baseUrl=baseUrl+"/user/listUsers";
        log.info("baseurl "+ baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),String.class);
        } catch (Exception ex) {
            log.error("Exception >", ex);
        }
        log.info(response.getBody());
    }


    public void getOrderApiGateway() throws RestClientException, IOException {

//        List<ServiceInstance> instances=discoveryClient.getInstances("spring-cloud-gateway");
//        ServiceInstance serviceInstance=instances.get(0);
//
//        String baseUrl=serviceInstance.getUri().toString();

        String baseUrl="http://localhost:8070/order/listOrders";
        log.info("baseurl "+ baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),String.class);
        } catch (Exception ex) {
            log.error("Exception >", ex);
        }
        log.info(response.getBody());
    }
    public void getUserApiGateway() throws RestClientException, IOException {
        //        List<ServiceInstance> instances=discoveryClient.getInstances("spring-cloud-gateway");
//        ServiceInstance serviceInstance=instances.get(0);
//
//        String baseUrl=serviceInstance.getUri().toString();

        String baseUrl="http://localhost:8070/user/listUsers";

        log.info("baseurl "+ baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),String.class);
        } catch (Exception ex) {
            log.error("Exception >", ex);
        }
        log.info(response.getBody());
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}

