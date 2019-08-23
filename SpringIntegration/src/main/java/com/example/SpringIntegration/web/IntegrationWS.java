package com.example.SpringIntegration.web;

import com.example.SpringIntegration.filters.BasicFilter;
import com.example.SpringIntegration.gateways.BasicGateWay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab/int")
public class IntegrationWS {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    @Autowired
    private BasicGateWay basicGateWay;
    @RequestMapping(value = "/test/{string}", method = RequestMethod.GET)
    public String testIntegration(@PathVariable("string") String string){
        logger.info("IntegrationWS!!!");
        return basicGateWay.modifyString(string);
    }
}
