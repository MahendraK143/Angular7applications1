package com.st.controller;

import com.st.repository.StackRepository;
import com.st.bean.StackBean;
import com.st.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StackController {
    @Autowired
    private StockService stockService;

    StackBean stackBean1 = new StackBean(1,"MAHINDRA",15550);
    StackBean stackBean2 = new StackBean(2,"TATA",17000);
    StackBean stackBean3 = new StackBean(3,"MARUTI",12000);
    StackBean stackBean4 = new StackBean(4,"BMW",23000);
    StackBean stackBean5 = new StackBean(5,"HONDA",10000);
    //List<StackBean> stocks =  Arrays.asList(stackBean1, stackBean2, stackBean3, stackBean4, stackBean4, stackBean5);
    List<StackBean> stocks = new ArrayList<>();

    @RequestMapping(value = "/stock-list",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> stackList(){
        System.out.println("Good LIST");
        if(stocks.size()==0){
            stocks.add(stackBean1);stocks.add(stackBean2);stocks.add(stackBean3);stocks.add(stackBean4);stocks.add(stackBean5);
        }
        return stocks;
    }
    @RequestMapping(value = "getStockById",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<StackBean> getStockById(@RequestParam("stockId") Integer stockId){
        System.out.println("stockId:"+stockId);
        //stocks.stream().filter(stackBean -> stackBean.getStackId()==stockId).findFirst();
        return stocks.stream().filter(stackBean -> stackBean.getStackId()==stockId).findFirst();
    }

    @RequestMapping(value = "searchStockByName",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> searchStockByName(@RequestParam("name") String name){
        System.out.println("searchStockByName:"+stocks);
        System.out.println("searchStockByName:"+name);
        //stocks.stream().filter(stackBean -> stackBean.getStackId()==stockId).findFirst();

        return stocks.stream().filter(stackBean -> stackBean.getName().contains(name)).collect(Collectors.toList());
    }

    @RequestMapping(value = "new-stock",method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> newStock(@RequestBody StackBean stock){
        System.out.println("Good POST:"+stock);
        stocks.add(stock);
        return stocks;
    }

    @RequestMapping(value = "update-stock",method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> updateStock(@RequestBody StackBean stock){
        System.out.println("Good UPDATE:"+stock);
        for (StackBean s: stocks) {
            if(s.getStackId()==stock.getStackId()){
                s.setName(stock.getName());
                s.setCost(stock.getCost());
            }
        }
        return stocks;
    }

    @RequestMapping(value = "delete-stock",method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> deleteStock(@RequestParam("stockId") Integer stockId){
        System.out.println("stockId delete:"+stockId);
        for (int i=0; i < stocks.size() ; i++) {
            if(stocks.get(i).getStackId()==stockId){
                stocks.remove(stocks.get(i)) ;
            }
        }
        return stocks;
    }

   /* @RequestMapping(value = "update",method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<StackBean> updateStock(@RequestBody StackBean stock){
        System.out.println("Good");
        *//*stocks = stocks.stream().filter(s -> s.getStackId() == stock.getStackId())
                .map(s -> {
                    s.setName(stock.getName());
                    s.setCost(stock.getCost());
                }).collect(Collectors.toList());*//*
        return stocks;
    }*/
    public static void main(String []arg){
        System.out.println(new StackController().searchStockByName("M"));
    }
}
