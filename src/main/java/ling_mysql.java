//package sqldstudent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ling_mysql {
    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jc.jdbc.Driver";
        //URL指向要访问的数据库名bookstore
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        //MySQL配置时的用户名
        String username = "root";
        //MySQL配置时的密码
        String password = "yyc123456";

        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //1.getConnection()方法，连接MySQL数据库！！
            con=null;
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行插入语句

            //要执行的SQL语句
            String sql = "select * from users";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("------------------------");
            System.out.println("学号" + "\t" + "姓名" + "\t" + "密码" + "\t" + "生日");
            System.out.println("--------------------------------------");
            String sname= null;
            String sid = null;
            String spassword = null;
            String semail = null;
            String sbirthday = null;
            while(rs.next()){
                //获取sno这列数据
                sid = rs.getString("id");
                //获取sname这列数据
                sname = rs.getString("name");
                //获取sex这列数据
                spassword = rs.getString("password");
                //获取age这列数据
                sbirthday = rs.getString("birthday");
                //输出结果
                System.out.println(sid + "\t" + sname + "\t" + spassword + "\t" + sbirthday);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally{
            System.out.println("数据库数据成功获取！！");
        }
    }

}