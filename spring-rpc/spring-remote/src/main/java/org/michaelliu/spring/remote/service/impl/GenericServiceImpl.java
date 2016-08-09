package org.michaelliu.spring.remote.service.impl;

import org.michaelliu.spring.remote.service.GenericService;

/**
 * Created by Michael on 8/9/16.
 */
public class GenericServiceImpl implements GenericService {

    @Override
    public <T> T createBean(Class<T> requiredType, Object[] args) {
        T bean = null;
        try {
            bean = requiredType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
