package com.example.SpringIntegration.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

@Component("filter")
public class BasicFilter {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    @Filter
    public boolean transform(String string){
        logger.info(" basic filter!!!");
        return !string.contains("{");
    }
}
