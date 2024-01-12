package SqlTran;

import java.sql.*;

import StartSys.SqlWork;

public class SqlManage {

    //连接数据库
    public static final String dburl = "jdbc:sqlserver://localhost:1433;databaseName=TicketMS2;trustServerCertificate=true";
    public static final String username = "sa";
    public static final String userpwd = "123456";
    public static Connection dbconn = null;

    public static void ConnectToServer(){
        try{
            dbconn = DriverManager.getConnection(dburl,username,userpwd);
            System.out.println("数据库连接成功");

            //test
           Statement stmt = dbconn.createStatement();
            ResultSet rs = null;
            System.out.println("数据库连接测试查询");
            String sql = "select * from Customer";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String Account= rs.getString("Cust_id");
                String Pwd = rs.getString("Cust_pwd");

            }
            System.out.println("数据库连接测试成功！");
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /*select
     * return:结果数量
     * sql:SQL语句
     * result:结果数据
     */
    public static int Select(SqlWork sw) {
        try {
            Statement stmt = dbconn.createStatement();
            ResultSet rs = stmt.executeQuery(sw.sql);
            if (rs.next()) {
                int count = rs.getInt(1); // Retrieve the count value from the result set
                stmt.close();
                return count;
            } else {
                stmt.close();
                return 0;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int Select1(SqlWork sw){
        try{
            Statement stmt = dbconn.createStatement();
            sw.rs = stmt.executeQuery(sw.sql);
            sw.addtolist();
            int count = sw.count;
            stmt.close();
            return count;
        }catch(SQLException se){
            se.printStackTrace();
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int Select2(SqlWork sw){
        try{
            Statement stmt = dbconn.createStatement();
            sw.rs = stmt.executeQuery(sw.sql);
            sw.addtolist();
            int count = sw.count;
            stmt.close();
            return count;
        }catch(SQLException se){
            se.printStackTrace();
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * Insert();
     *
     */
    public static boolean Insert(SqlWork sw) {
        // TODO 自动生成的方法存根
        try{
            Statement stmt = dbconn.createStatement();

            stmt.executeUpdate(sw.sql);

            stmt.close();
            return true;
        }catch(SQLException se){
            System.out.println("---------------Insert 异常");
            se.printStackTrace();
            return false;
        }

    }
    /*
     * 存储过程
     */
    public static boolean ExecPro(SqlWork sw){
        try{
            Statement stmt = dbconn.createStatement();
            stmt.executeUpdate(sw.sql);
            stmt.close();
            return true;
        }catch(SQLException se){
            System.out.println("---------------ExecPro异常");
            se.printStackTrace();
            return false;
        }
    }
    /*
     * Delete
     */
    public static boolean Delete(SqlWork sw){
        try{
            Statement stmt = dbconn.createStatement();

            stmt.executeUpdate(sw.sql);

            stmt.close();
            return true;
        }catch(SQLException se){
            System.out.println("---------------Delete异常");
            se.printStackTrace();
            return false;
        }
    }
    /*
     * Update()
     */
    public static boolean Update(SqlWork sw){
        try{
            Statement stmt = dbconn.createStatement();

            stmt.executeUpdate(sw.sql);

            stmt.close();
            return true;
        }catch(SQLException se){
            System.out.println("---------------Update异常");
            se.printStackTrace();
            return false;
        }
    }
}
