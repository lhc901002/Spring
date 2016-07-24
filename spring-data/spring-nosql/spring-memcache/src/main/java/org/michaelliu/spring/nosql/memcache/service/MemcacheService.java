package org.michaelliu.spring.nosql.memcache.service;

import com.danga.MemCached.MemCachedClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by michael on 2016/7/25.
 */
@Service
public class MemcacheService {

    private static final Log log = LogFactory.getLog(MemcacheService.class);

    @Autowired
    private MemCachedClient memCachedClient;

    public <T extends Serializable> T getValue(String key) {
        T value = null;
        if (memCachedClient.keyExists(key)) {
            value = (T) memCachedClient.get(key);
        }
        log.info("getValue returns: " + value);
        return value;
    }

    public <T extends Serializable> boolean setValue(String key, T value) {
        log.info("setValue receives: " + key + ", " + value);
        boolean result;
        if (memCachedClient.keyExists(key)) {
            result = memCachedClient.set(key, value);
        } else {
            result = memCachedClient.add(key, value);
        }
        log.info("setValue returns: " + result);
        return result;
    }

    public boolean remove(String key) {
        boolean result = false;
        if (memCachedClient.keyExists(key)) {
            result = memCachedClient.delete(key);
        }
        return result;
    }

    public long addOrIncr(String key, Integer inc) {
        long counter = memCachedClient.addOrIncr(key, inc);
        log.info("addOrIncr returns: " + counter);
        return counter;
    }

}
