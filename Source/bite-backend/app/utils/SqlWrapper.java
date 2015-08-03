package utils;

import play.db.*;

import java.sql.*;
import java.util.*;

public class SqlWrapper {
    private Connection connection;

    public SqlWrapper() {
        connection = DB.getConnection();
    }

    public ResultSet getSingleData(String sql) throws SQLException {
        ResultSet rs;
        Statement stmt;
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public ResultSet getMultipleData(String sql) throws SQLException {
        ResultSet rs;
        Statement stmt;
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public ResultSet getMultipleData(String sql, int limit) throws SQLException {
        if (!sql.contains(" limit "))
            sql += " limit 0," + limit;
        return getMultipleData(sql);
    }

    public ResultSet getMultipleData(String sql, int limit, int start) throws SQLException {
        if (!sql.contains(" limit "))
            sql += " limit " + start + "," + limit;
        return getMultipleData(sql);
    }

    public void createData(PreparedStatement preparedStatement) throws SQLException {
        //think of whether to process return status of the statement.
        preparedStatement.executeUpdate();
    }

    public static List<Map<String, Object>> convertToObjects(ResultSet rs) throws SQLException {
        List<Map<String, Object>> records = new ArrayList<>();
        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            Map<String, Object> individualRecord = new HashMap<>();
            for (int i = 0; i < cols; i++) {
                individualRecord.put(rs.getMetaData().getColumnName(i + 1), rs.getObject(i + 1));
            }
            records.add(individualRecord);
        }
        return records;
    }

    public static Map<String, Object> convertToObject(ResultSet rs) throws SQLException {
        Map<String, Object> record = new HashMap<>();
        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            for (int i = 0; i < cols; i++) {
                record.put(rs.getMetaData().getColumnName(i + 1), rs.getObject(i + 1));
            }

        }
        return record;
    }

    public void Finish() {
        try {
            connection.close();
        } catch (Exception e) {

        }
    }
}
