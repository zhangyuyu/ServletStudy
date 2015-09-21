package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Hello extends HttpServlet {
    private Connection conn;
    private Statement stmt;
    ResultSet rs=null;

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=GBK");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=GBK\">");
        out.println("<title>DataBase Connection</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<center>");
        String url="jdbc:mysql://localhost:3306/test";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, "root", "0523");
            stmt=conn.createStatement();

            String insertSql ="INSERT raw_report(myname, mysex, myage, mybirthday) VALUES(?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("sex"));
            pstmt.setString(3, request.getParameter("age"));
            pstmt.setString(4, request.getParameter("birthday"));
            pstmt.executeUpdate();

            String querySql="select * from raw_report;";
            rs=stmt.executeQuery(querySql);

            out.println("Servlet访问数据库成功");
            out.println("<table>");
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

            out.println(
                    "<html>\n" +
                    "<body>\n" +
                    "<h1 align=\"center\">" + "new member" + "</h1>\n" +
                    "<b>Name</b>: "
                    + request.getParameter("name") + "</br>" +
                    "<b>Sex</b>: "
                    + request.getParameter("sex") + "</br>" +
                    "<b>Age</b>: "
                    + request.getParameter("age") + "</br>" +
                    "<b>Birthday</b>: "
                     + request.getParameter("birthday") + "</br>" +
                    "</body>"+"</html>");
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
