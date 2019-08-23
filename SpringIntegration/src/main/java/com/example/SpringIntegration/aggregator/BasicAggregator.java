package com.example.SpringIntegration.aggregator;

import com.example.SpringIntegration.filters.BasicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("aggregator")
public class BasicAggregator {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    public String splitter(List<String> strings){
        logger.info(" BasicAggregator!!!");
        return strings.stream().reduce((s1, s2) -> s1+"_"+s2 ).get();
    }

}
