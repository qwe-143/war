import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CRUDServlet extends HttpServlet {

    static final String URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASS = "12345";

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement();

            // CREATE
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS course(id INT PRIMARY KEY, name VARCHAR(30))");
            out.println("<h3>Table created</h3>");

            // CLEAR OLD DATA
            stmt.executeUpdate("DELETE FROM course");

            // INSERT
            stmt.executeUpdate("INSERT INTO course VALUES(1,'C')");
            stmt.executeUpdate("INSERT INTO course VALUES(2,'Java')");
            out.println("<h3>Inserted</h3>");

            // READ
            ResultSet rs = stmt.executeQuery("SELECT * FROM course");
            out.println("<h3>Data:</h3>");
            while (rs.next()) {
                out.println(rs.getInt("id") + " --- " + rs.getString("name") + "<br>");
            }

            // UPDATE
            stmt.executeUpdate("UPDATE course SET name='J2EE' WHERE id=2");
            out.println("<h3>Updated</h3>");

            // DELETE
            stmt.executeUpdate("DELETE FROM course WHERE id=1");
            out.println("<h3>Deleted</h3>");

            // FINAL OUTPUT
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM course");
            out.println("<h3>Final Data:</h3>");
            while (rs2.next()) {
                out.println(rs2.getInt(1) + " --- " + rs2.getString(2) + "<br>");
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}