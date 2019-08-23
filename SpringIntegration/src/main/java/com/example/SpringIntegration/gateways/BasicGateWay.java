package com.example.SpringIntegration.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.stereotype.Component;

@Component
public interface BasicGateWay {
    @Gateway
    String modifyString(String string);
}
