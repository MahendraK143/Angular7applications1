package com.st.service;

import com.st.bean.StackBean;
import com.st.repository.StackRepository;
import com.st.repository.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService{
    @Autowired
    private StockDAO stockDAO;

    StackBean stackBean1 = new StackBean(1,"MAHINDRA",15550);
    StackBean stackBean2 = new StackBean(2,"TATA",17000);
    StackBean stackBean3 = new StackBean(3,"MARUTI",12000);
    StackBean stackBean4 = new StackBean(4,"BMW",23000);
    StackBean stackBean5 = new StackBean(5,"HONDA",10000);
    List<StackBean> stacks =  Arrays.asList(stackBean1, stackBean2, stackBean3, stackBean4, stackBean4, stackBean5);
    @Override
    public List<StackBean> getAllStockInformation() {
        return stacks;
        //return stockDAO.getAllStockInformation();
    }
}
