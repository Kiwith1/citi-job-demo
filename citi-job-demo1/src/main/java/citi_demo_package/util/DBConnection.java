package citi_demo_package.util;
/** A beolvasáshoz szükséges SQL bővítmények importálása */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/** A MYSQL táblát ez olvassa be*/
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/crud_demo/users";
    private static final String USER = "root";
    private static final String PASSWORD = "Imadeyoudontresist";
    /** Az adatokat kiszedi a táblából*/
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
