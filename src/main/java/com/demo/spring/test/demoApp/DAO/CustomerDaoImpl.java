package com.demo.spring.test.demoApp.DAO;


import com.demo.spring.test.demoApp.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    private Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        if(session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public int addCustomer(Customer customer) {
        Long id = (Long) getSession().save(customer);
        return  Integer.valueOf(id.toString());
    }
}
