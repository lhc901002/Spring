package org.michaelliu.demo.spring.mybatis.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.michaelliu.demo.spring.mybatis.dto.Account;
import org.michaelliu.demo.spring.mybatis.vo.AccountVo;

import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/AccountService
 * Hessian: http://localhost:8080/hessian/AccountService
 * cxf: http://localhost:8080/cxf/AccountService
 */
public interface AccountService {

    int saveOrUpdateSelective(Account account) throws Exception;

    AccountVo findById(Long id);

    List<AccountVo> findByName(String name);

    PageList findPageListByName(String name, Integer page, Integer pageSize);

    PageList findPageListByIdList(List<Long> idList, Integer page, Integer pageSize);

}
