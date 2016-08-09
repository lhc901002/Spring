package org.michaelliu.spring.remote.service;

/**
 * Created by Michael on 8/9/16.
 */
public interface GenericService {

    <T> T createBean(Class<T> requiredType, final Object[] args);

}
