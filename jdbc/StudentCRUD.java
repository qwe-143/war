import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "root"; // change

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1.Insert  2.Read  3.Update  4.Delete  5.Exit");
                int ch = sc.nextInt();

                if (ch == 1) { // INSERT
                    System.out.print("Enter id name marks: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int marks = sc.nextInt();

                    PreparedStatement ps =
                        con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, marks);
                    ps.executeUpdate();

                    System.out.println("Inserted");
                }

                else if (ch == 2) { // READ
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM student");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("marks")
                        );
                    }
                }

                else if (ch == 3) { // UPDATE
                    System.out.print("Enter id and new marks: ");
                    int id = sc.nextInt();
                    int marks = sc.nextInt();

                    PreparedStatement ps =
                        con.prepareStatement("UPDATE student SET marks=? WHERE id=?");
                    ps.setInt(1, marks);
                    ps.setInt(2, id);
                    ps.executeUpdate();

                    System.out.println("Updated");
                }

                else if (ch == 4) { // DELETE
                    System.out.print("Enter id to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps =
                        con.prepareStatement("DELETE FROM student WHERE id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    System.out.println("Deleted");
                }

                else break;
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//javac -cp ".;mysql-connector-j-9.5.0.jar" StudentCRUD.java
//java  -cp ".;mysql-connector-j-9.5.0.jar" StudentCRUD