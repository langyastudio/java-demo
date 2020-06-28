package jdbc;

import java.sql.*;

public class JdbcT {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.123.22:3306/hc_opens_test", "root", "daemon");) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, user_name, nick_name FROM os_user WHERE user_name=?",
                                                              Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "jjxt");

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println(rs.getString("nick_name"));
                    }
                }
            }
        }
    }
}
