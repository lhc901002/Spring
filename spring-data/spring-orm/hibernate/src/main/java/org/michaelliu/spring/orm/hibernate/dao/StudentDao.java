package org.michaelliu.spring.orm.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Michael on 7/12/16.
 */
@Repository
public class StudentDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    public String selectStudentById(Long id) {
//        String hql = "select bookName from Book where id = ?";
//        Query query=getSession().createQuery(hql).setInteger(0, id);
//        String str= query.uniqueResult().toString();
//        return str;
//    }



}
