package com.example.SpringIntegration.splitters;

import com.example.SpringIntegration.filters.BasicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("splitter")
public class BasicSplitter {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    public List<String> splitter(String string){
        logger.info(" BasicSplitter!!!");
        return string.chars().mapToObj(c -> (char)c).map(s -> s.toString()).collect(Collectors.toList());
    }

}
