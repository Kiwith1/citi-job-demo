package citi_demo_package.CRUD;
/** A többi package meghívása */
import citi_demo_package.model.User;
import citi_demo_package.util.DBConnection;
/** Az adatbázis kezeléséhez és listákhoz szükséges SQL bővítmények importálása */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD {

    /** 1.Felhasználó létrehozása*/
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCountry());

            stmt.executeUpdate();
        }
    }

    /** 2.Adatok lekérése ID alapján */
    public User selectUser(int id) throws SQLException {
        String sql = "SELECT id, name, email, country FROM users WHERE id = ?";
        User user = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("country")
                );
            }
        }
        return user;
    }

    /** 3.Összes felhasználó kiírása*/
    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name, email, country FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("country")
                );
                users.add(user);
            }
        }
        return users;
    }

    /** 4.Felhasználó szerkesztése*/
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
        boolean rowUpdated;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCountry());
            stmt.setInt(4, user.getId());

            rowUpdated = stmt.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    /** 5. felhasználó törlése id alapján */
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        boolean rowDeleted;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
