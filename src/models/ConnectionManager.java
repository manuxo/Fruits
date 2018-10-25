package models;

import java.sql.*;

public class ConnectionManager {
    public static String url = "jdbc:mysql://localhost:3306/demojdbc?useSSL=false";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String username = "root";
    public static String password = "admin";
    public static Connection connection;

    public static synchronized Connection getConnection() throws ClassNotFoundException,SQLException{
        Class.forName(driver);
        connection = (Connection) DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement pstmt){
        try{
            if(pstmt != null){
                pstmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}