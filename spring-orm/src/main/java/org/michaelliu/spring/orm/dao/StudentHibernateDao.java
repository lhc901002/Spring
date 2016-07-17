package org.michaelliu.spring.orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by Michael on 7/12/16.
 */
//@Repository
public class StudentHibernateDao {

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
