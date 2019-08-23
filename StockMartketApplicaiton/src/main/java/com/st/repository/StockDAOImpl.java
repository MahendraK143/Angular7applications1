package com.st.repository;

import com.st.bean.StackBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDAOImpl implements StockDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<StackBean> getAllStockInformation() {
        Session session = sessionFactory.getCurrentSession();
        //session.createQuery()
        return null;
    }
}
