package com.nuc.util;

import com.nuc.util.DatabaseUtil;

import java.sql.*;
import java.util.Arrays;

public class BaseDao {

    static String driver = "com.mysql.jdbc.Driver";
    static String username = "root";
    static String password = "123456";
    static String url = "jdbc:mysql://localhost:3306/bookshop?serverTimezone=UTC&characterEncoding=utf-8";
    static Connection conn = null;


    static {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增、删、改操作
     * @param sql
     *        语句
     * @param params
     *         参数数组
     * @return 执行结果
     */
    public int executeUpdate(String sql,Object...params) {
        int result=0;
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,pstmt,null);
        }
        return  result;
    }

    /**
     *
     * @param sql
     *        语句
     * @param params
     *         参数数组
     * @return  查询结果集
     */
    public ResultSet executeQuery(String sql, Object...params){
        //System.out.println(sql);
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
            rs=pstmt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  rs;
    }


    public void runback(){
        //事务回滚
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        //事务提交
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
