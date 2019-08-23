package com.st.repository;

import com.st.bean.StackBean;

import java.util.List;

public interface StockDAO {
    List<StackBean> getAllStockInformation();
}
