import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class First_psJDBC {
    public static void main(String[] args) throws Exception {
        //注册驱动
       // Class.forName("com.mysql.jc.jdbc.Driver");
        String driver = "com.mysql.jc.jdbc.Driver";
        //建立连接
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "yyc123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("打开到数据库的连接：" + conn);

        //创建statment对象
        Statement stmt = conn.createStatement();

        //执行SQL语句
        String sql = "select * from users";

        //处理数据
        ResultSet rs = stmt.executeQuery(sql);
        //(next方法，向下走一次取到一个值，boolean 类型)
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString(2);
            System.out.println(id + "\t" +name);
        }

        //关闭资源
        rs.close();
        stmt.close();
        conn.close();

    }

}
