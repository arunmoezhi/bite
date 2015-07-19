package utils;

import play.db.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SqlWrapper {
    private Connection connection;

    public SqlWrapper() {
        connection = DB.getConnection();
    }

    public Object getSingleData(String sql) throws SQLException {
        ResultSet rs = null;
        Statement stmt = null;
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);
        return convertToObject(rs, true);
    }

    public Object getMultipleData(String sql) throws SQLException {
        ResultSet rs = null;
        Statement stmt = null;
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);
        return convertToObject(rs, false);
    }

    public Object getMultipleData(String sql, int limit) throws SQLException {
        if (!sql.contains(" limit "))
            sql += " limit 0," + limit;
        return getMultipleData(sql);
    }

    public Object getMultipleData(String sql, int limit, int start) throws SQLException {
        if (!sql.contains(" limit "))
            sql += " limit " + start + "," + limit;
        return getMultipleData(sql);
    }

    public Object convertToObject(ResultSet rs, boolean isSingle) throws SQLException {
        List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            HashMap arr = new HashMap();
            for (int i = 0; i < cols; i++) {
                arr.put(rs.getMetaData().getColumnName(i + 1), rs.getObject(i + 1));
            }
            if (isSingle) {
                return arr;
            }
            records.add(arr);
        }
        return records;
    }

    public void Finish() {
        try {
            connection.close();
        } catch (Exception e) {

        }
    }
}
