package com.epam.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetFields {

    public static String getStringByName(String columnName, ResultSet resultSet) throws SQLException {
        return resultSet.getString(columnName);
    }

    public static int getIntByName(String columnName, ResultSet resultSet) throws SQLException {
        return resultSet.getInt(columnName);
    }

    public static boolean getBooleanByName(String columnName, ResultSet resultSet) throws SQLException {
        return resultSet.getBoolean(columnName);
    }
}
