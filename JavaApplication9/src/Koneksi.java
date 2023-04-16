

import java.sql.*;

public class Koneksi {
    public static Connection getConnection() throws Exception {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klinik_blackpink", "root",
                    "root");
            return conn;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
