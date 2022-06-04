package com.dustin.handler;

import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateStringHandler
 * @Descrption TODO
 * @Date 2021/8/7上午 03:52
 * @Created By Dustin_Peng
 */
public class DateStringHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = smp.format(date);
        preparedStatement.setString(i,timeStr);
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getDate(resultSet.getString(s),  1);

    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getDate(resultSet.getString(i),  i);
    }


    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getDate(callableStatement.getString(i),  i);
    }

    private Date getDate(String string,  int i) throws SQLException {
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sqlDateStr = string;
        Date nowDate = new Date();
        Date date =null;

        try {
            date=smp.parse(sqlDateStr);
        } catch (ParseException | NullPointerException e) {
            date=nowDate;
        }
        return date;
    }
}
