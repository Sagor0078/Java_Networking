

import java.io.*;
import java.sql.*;

public class ICE_PUSTDB {
    public static void main(String[] args){
        Connection con = null;
        Statement stnt = null;
        ResultSet rs = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1;
        String email1;
        String phone1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherreg", "main", "sagor0078");
            stnt = con.createStatement();

            String sql1 = "SELECT name,email,phone FROM teacherinfo";
            rs = stnt.executeQuery(sql1);
            while (rs.next()) {
            	name1= rs.getString("name");
                email1= rs.getString("email");
                phone1= rs.getString("phone");
                System.out.println("ID :" + name1);
                System.out.println("roll: " + email1);
                System.out.println("email : " + phone1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stnt != null) {
                    stnt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}