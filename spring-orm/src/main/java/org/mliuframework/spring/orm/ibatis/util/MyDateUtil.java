package org.mliuframework.spring.orm.ibatis.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类MyDateUtil
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
public class MyDateUtil {

    public static Date getDateTimeByFormat(Date date, String formatter) {
        if (StringUtils.isEmpty(formatter)) {
            formatter = "yyyy-MM-dd hh:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        Date objDate = null;
        try {
            objDate = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            objDate = null;
            e.printStackTrace();
        }
        return objDate;
    }

    public static Date getCurrentDateTime() {
        return getDateTimeByFormat(new Date(), "yyyy-MM-dd hh:mm:ss");
    }

    public static String getCurrentDateTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date());
    }

}
