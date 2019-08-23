package com.example.SpringIntegration.transformers;

import com.example.SpringIntegration.filters.BasicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component("transformer")
public class BasicTransformer {
    public  static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    @Transformer
    public String transform(String string){
        logger.info(" BasicTransformer!!!");
        return string.toUpperCase();
    }
}
