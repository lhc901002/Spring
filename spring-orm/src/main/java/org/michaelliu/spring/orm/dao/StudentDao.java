package org.michaelliu.spring.orm.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 7/13/16.
 */
@Repository
public class StudentDao extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List findPageList(PageBounds pageBounds){
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("StudentMapper.selectAll", params, pageBounds);
    }

    public List findPageListByName(String name, PageBounds pageBounds){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return getSqlSession().selectList("StudentMapper.selectByName", params, pageBounds);
    }

}
