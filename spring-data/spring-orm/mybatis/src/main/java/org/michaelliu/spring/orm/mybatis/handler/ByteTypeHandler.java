package org.michaelliu.spring.orm.mybatis.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Michael on 7/28/16.
 */
public class ByteTypeHandler implements TypeHandler {

    private static final Log log = LogFactory.getLog(ByteTypeHandler.class);


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        return getStatusInfo(resultSet.getByte(s));
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return getStatusInfo(resultSet.getByte(i));
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return getStatusInfo(callableStatement.getByte(i));
    }

    private Object getStatusInfo(Byte status) {
        String statusInfo = "";
        if (null != status) {
            switch (status) {
                case 1:
                    statusInfo = "on sale";
                    break;
                case 2:
                    statusInfo = "no stock";
                    break;
                case 3:
                    statusInfo = "off stock";
                    break;
                default:
                    statusInfo = "other";
            }
        }
        log.info("statusInfo: " + statusInfo);
        return statusInfo;
    }

}
