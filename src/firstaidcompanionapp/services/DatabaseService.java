package firstaidcompanionapp.services;

import java.sql.*;

public class DatabaseService {

    // ✅ Path to database (placed in project root)
    private static final String DB_PATH = "firstaid.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;

    public DatabaseService() {
        System.out.println("📘 Using database path: " + DB_PATH);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public String getInstruction(String symptomName) {
        String sql = "SELECT instruction FROM symptoms WHERE LOWER(name) = LOWER(?)";
        String instruction = "No first aid instruction found.";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, symptomName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                instruction = rs.getString("instruction");
            }

        } catch (SQLException e) {
            instruction = "⚠️ Database error: " + e.getMessage();
        }

        return instruction;
    }
}