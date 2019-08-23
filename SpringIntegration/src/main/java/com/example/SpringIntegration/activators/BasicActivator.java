package com.example.SpringIntegration.activators;

import com.example.SpringIntegration.filters.BasicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("activator")
public class BasicActivator {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    public String splitter(String string){
        logger.info(" BasicActivator!!!");
        return string.replace("_","__");
    }

}
