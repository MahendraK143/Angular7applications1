package com.example.SpringIntegration.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"spring-integration.xml"})
public class JavaConfig {
}
