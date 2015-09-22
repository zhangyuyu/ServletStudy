package servlet;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hello extends HttpServlet {
    private Connection conn;
    private Statement stmt;
    ResultSet rs=null;

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        List<Customer> customerList = new ArrayList<Customer>();
        response.setContentType("text/html;charset=GBK");
        String url="jdbc:mysql://localhost:3306/test";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, "root", "0523");
            stmt=conn.createStatement();

            addCustomerToDB(request, conn);
            request.setAttribute("customerList",  getCustomersFromDB(customerList));

            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    private List<Customer> getCustomersFromDB(List<Customer> customerList) throws SQLException {
        String querySql="select * from raw_report;";
        rs=stmt.executeQuery(querySql);
        while (rs.next()){
            customerList.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        return customerList;
    }

    private void addCustomerToDB(HttpServletRequest request, Connection conn) throws SQLException {
        String insertSql ="INSERT raw_report(myname, mysex, myage, mybirthday) VALUES(?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(insertSql);
        pstmt.setString(1, request.getParameter("name"));
        pstmt.setString(2, request.getParameter("sex"));
        pstmt.setString(3, request.getParameter("age"));
        pstmt.setString(4, request.getParameter("birthday"));
        pstmt.executeUpdate();
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        this.doGet(req,resp);
    }

}
