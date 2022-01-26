package com.sapiens.wyrwalm.ridemon.controller;

import com.sapiens.wyrwalm.ridemon.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.jta.atomikos.AtomikosDependsOnBeanFactoryPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@org.springframework.stereotype.Service
@Slf4j
public class TestController {
    private final Service service;

    public TestController(Service service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String testController() {
        log.info("test controller hit");
        return "Test controller work as intended";
    }

    @GetMapping("/service")
    @SuppressWarnings("unchecked")
    public int serviceTest(@RequestBody String json) throws ParseException {
        /*  dodac obsluge bledow */
        JSONParser parser = new JSONParser(json);
        return service.toLog((Map<String, String>) parser.parse());
    }
}
