package org.michaelliu.spring.mybatis.service.impl;

import org.michaelliu.spring.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Michael on 8/10/16.
 */
@Service("transactionService")
@WebService(endpointInterface = "org.michaelliu.spring.service.TransactionService")
public class TransactionServiceImpl implements TransactionService {
}
