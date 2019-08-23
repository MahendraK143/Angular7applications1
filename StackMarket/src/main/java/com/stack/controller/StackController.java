package com.stack.controller;

import com.stack.bean.StackBean;
import com.stack.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class StackController {
    @Autowired
    private StackRepository stackRepository;

    @RequestMapping(name = "stock-list",method = RequestMethod.GET)
    public List<StackBean> stackList(){
        System.out.println("Good");
        return stackRepository.findAll();
    }

}
