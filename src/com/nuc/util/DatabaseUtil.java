package com.nuc.util;

import java.sql.*;

public class DatabaseUtil {
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        try {
            if (rs!=null&&!rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt!=null&&!stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
