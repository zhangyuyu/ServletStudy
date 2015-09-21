package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBServlet extends HttpServlet{            //定义一个继承HttpServlet的公有类
    private Connection conn;                        //初始化连接
    private Statement stmt;                        //初始化数据库操作
    ResultSet rs=null;                            //初始化结果集

    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        resp.setContentType("text/html;charset=GBK");    //设置字符编码格式
        PrintWriter out=resp.getWriter();                //实例化对象，用于页面输出
        out.println("<html>");                    //实现生成静态Html
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=GBK\">");
        out.println("<title>DataBase Connection</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<center>");
        String url="jdbc:mysql://localhost:3306/test";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,"root","0523");
            stmt=conn.createStatement();
            String sql="select * from raw_report;";
            rs=stmt.executeQuery(sql);
            out.println("Servlet访问数据库成功");
            out.println("<table border=1 bordercolorlight=#000000>");
            out.println("<tr><td width=40>name</td>");
            out.println("<td>sex</td>");
            out.println("<td>age</td>");
            out.println("<td>birthday</td>");
            while(rs.next()){
                out.println("<tr><td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<tr>");
            }
            out.println("</table>");
            rs.close();
            stmt.close();
            conn.close();
        }   catch(Exception e){
                e.printStackTrace();
                out.println(e.toString());
        }
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        this.doGet(req,resp);
    }
}