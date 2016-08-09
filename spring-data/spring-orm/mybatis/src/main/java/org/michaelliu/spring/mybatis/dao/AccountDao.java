package org.michaelliu.spring.mybatis.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

/**
 * Created by Michael on 7/13/16.
 */
public interface AccountDao {

    List findPageListByName(String name, PageBounds pageBounds);

    List findPageListByIdList(List<Long> idList, PageBounds pageBounds);

}
